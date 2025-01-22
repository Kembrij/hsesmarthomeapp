package ru.kembrij.smarthomeapi.mqtt;

import jakarta.annotation.PostConstruct;
import jakarta.annotation.PreDestroy;
import lombok.extern.slf4j.Slf4j;
import org.eclipse.paho.client.mqttv3.MqttException;
import org.springframework.stereotype.Component;

@Component
@Slf4j
public class MQTTModule implements MqttManagerListener {

    private MQTTOptions mqttOptions = null;
    private MQTTListener mqttListener = null;
    private MQTTService mqttService = null;
/*
    MQTTModule(MQTTOptions mqttOptions, MQTTListener mqttListener) {
        this.mqttOptions = mqttOptions;
        this.mqttListener = mqttListener;
    }

 */

    @PostConstruct
    void onStart() {
        log.info("MQTT модуль стартует");
        if (mqttService == null) {
            try {
                mqttService = new MQTTService(mqttOptions, this);
            } catch (Exception e) {
                log.info("Во время старта MQTT модуля произошла ошибка" + e.getMessage());
            }

        } else if (mqttOptions.hasUpdates()) {
            log.info("readMqttOptions().hasUpdates(): " + mqttOptions.hasUpdates());
        }
        try {
            mqttService.reconfigure(mqttOptions, this);
            mqttOptions.setOptionsUpdated(false);
        } catch (Exception e) {
            log.info("Во время старта MQTT модуля произошла ошибка" + e.getMessage());
        }
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

    void restart() {
        log.info("Перезапуск приложения");
        onStop();
        onStart();
    }

    void pause() {
        log.info("Приложение поставленно на паузу");
        onStop();
    }

    void publishCommand(String command, String message) {
        log.info("Команда: " + command + "Сообщение: " + message);
        if (mqttService != null) {
            mqttService.publishCommand(command, message);
        }

    }

    @Override
    public void subscriptionMessage(String id, String topic, String payload) {
        log.info("topic: " + topic + " payload: " + payload);
        mqttListener.onMQTTMessage(id, topic, payload);
    }

    @Override
    public void handleMqttException(String errorMessage) {
        mqttListener.onMQTTException(errorMessage);
    }

    @Override
    public void handleMqttDisconnected() {
        mqttListener.onMQTTDisconnect();
    }

    @Override
    public void handleMqttConnected() {
        mqttListener.onMQTTConnect();
    }
}
