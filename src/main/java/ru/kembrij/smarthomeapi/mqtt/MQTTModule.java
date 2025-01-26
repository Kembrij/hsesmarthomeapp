package ru.kembrij.smarthomeapi.mqtt;

import io.reactivex.rxjava3.disposables.CompositeDisposable;
import jakarta.annotation.PostConstruct;
import jakarta.annotation.PreDestroy;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.eclipse.paho.client.mqttv3.*;
import org.eclipse.paho.client.mqttv3.persist.MemoryPersistence;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import ru.kembrij.smarthomeapi.exceptions.AppException;
import ru.kembrij.smarthomeapi.exceptions.NotFoundException;
import ru.kembrij.smarthomeapi.service.impl.DeviceServiceImpl;
import ru.kembrij.smarthomeapi.service.impl.DeviceStateServiceImpl;
import ru.kembrij.smarthomeapi.service.impl.SensorDataServiceImpl;
import ru.kembrij.smarthomeapi.service.impl.SensorServiceImpl;

import java.util.ArrayList;

@Component
@Slf4j
@AllArgsConstructor
@NoArgsConstructor
public class MQTTModule implements MqttManagerListener, IMqttMessageListener {

    @Autowired
    private SensorServiceImpl sensorService;

    @Autowired
    private SensorDataServiceImpl sensorDataService;

    @Autowired
    private DeviceServiceImpl deviceService;

    @Autowired
    private DeviceStateServiceImpl deviceStateService;

    @Autowired
    private MQTTOptions mqttOptions;

    @Autowired
    private MQTTListenerIml listener;

    @Autowired
    private MQTTService mqttService;


    private MqttClient mqttClient = null;


    @PostConstruct
    void onStart() throws MqttException {
        log.info("MQTT модуль стартует");

        try {
            mqttService.reconfigure(mqttOptions, this);
            mqttOptions.setOptionsUpdated(false);
        } catch (Exception e) {
            log.info("Во время старта MQTT модуля произошла ошибка" + e.getMessage());
        }
        initializeMqttClient();
        subscribeToSensorTopics();
        subscribeToDeviceTopics();
    }

         void subscribeToSensorTopics() throws MqttException {
        ArrayList<String> allSenorsTopics = mqttService.getAllTopicsOfSensors();
        allSenorsTopics.forEach((topic) -> {
            try {
                mqttClient.subscribeWithResponse(topic, 0, this);
            } catch (MqttException e) {
            }
        });
    }

        void subscribeToDeviceTopics() {
            ArrayList<String> allDeviceTopics = mqttService.getAllTopicsOfDevices();
            allDeviceTopics.forEach((topic) -> {
                try {
                    mqttClient.subscribeWithResponse(topic, 0, this);
                } catch (MqttException e) {
                }
            });
        };


    void initializeMqttClient() throws MqttException {
        log.info("initializeMqttClient");
        if (mqttClient == null) {

            mqttClient = new MqttClient(mqttOptions.getServerURI(),
                    mqttOptions.getPublisherId(),
                    new MemoryPersistence());

            MqttConnectOptions options = new MqttConnectOptions();
            options.setAutomaticReconnect(true);
            options.setCleanSession(true);
            options.setConnectionTimeout(10);

            if (!mqttClient.isConnected()) {
                mqttClient.connect(options);
            }
        }
        mqttClient.setCallback(new MqttCallbackExtended() {
            @Override
            public void connectComplete(boolean b, String s) {
                log.info("Подключение к брокеру установленно");
            }

            @Override
            public void connectionLost(Throwable throwable) {

            }

            @Override
            public void messageArrived(String s, MqttMessage mqttMessage) throws Exception {

            }

            @Override
            public void deliveryComplete(IMqttDeliveryToken iMqttDeliveryToken) {

            }
        });


    }

    @PreDestroy
    void onStop() {
        log.info("MQTT модуль завершает работу");

        if (mqttService != null) {
            try {
                mqttService.close();
            } catch (MqttException e) {
                e.printStackTrace();
            }
            mqttService = null;
        }
    }

    void restart() throws MqttException {
        log.info("Перезапуск приложения");
        onStop();
        onStart();
    }

    void pause() {
        log.info("Приложение поставленно на паузу");
        onStop();
    }


    @Override
    public void subscriptionMessage(String id, String topic, String payload) {
        log.info("topic: " + topic + " payload: " + payload);
        listener.onMQTTMessage(id, topic, payload);
    }

    @Override
    public void handleMqttException(String errorMessage) {
        mqttService.onMQTTException(errorMessage);
    }

    @Override
    public void handleMqttDisconnected() {
        mqttService.onMQTTDisconnect();
    }

    @Override
    public void handleMqttConnected() {
        mqttService.onMQTTConnect();
    }

    @Override
    public void messageArrived(String s, MqttMessage mqttMessage) throws Exception {
        log.info("Сообщение MQTT получено: {}", new String(mqttMessage.getPayload()));
        log.info("Строка: {}", s);
        var sensor = sensorService.findByTopic(s);
        if (sensor != null) {
            var sensorTemp = sensorService.findByTopic(s);
            var sensorData = sensorDataService.findById(sensorTemp.getId());
        }
        else {
            var device = deviceService.findByTopic(s);
            var deviceState = deviceStateService.findByDevice(device).orElseThrow(() -> new NotFoundException("Состояние девайса ненайдено"));
            log.info(deviceState.toString());
            deviceStateService.update(deviceState);
        }

    }
}
