package ru.kembrij.smarthomeapi.mqtt;

import io.reactivex.rxjava3.disposables.CompositeDisposable;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;
import lombok.extern.slf4j.Slf4j;
import org.eclipse.paho.client.mqttv3.MqttCallback;
import org.eclipse.paho.client.mqttv3.MqttClient;
import org.eclipse.paho.client.mqttv3.MqttException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.kembrij.smarthomeapi.model.entity.Device;
import ru.kembrij.smarthomeapi.model.entity.Sensor;
import ru.kembrij.smarthomeapi.repository.DeviceRepository;
import ru.kembrij.smarthomeapi.repository.DeviceStateRepository;
import ru.kembrij.smarthomeapi.repository.SensorRepository;
import ru.kembrij.smarthomeapi.service.impl.SensorServiceImpl;
import ru.kembrij.smarthomeapi.service.impl.SensorTypeServiceImpl;

import java.util.ArrayList;
import java.util.List;


@Service
@Slf4j
@NoArgsConstructor
public class MQTTService implements MQTTServiceInterface, AutoCloseable, MQTTListener {

    @Autowired
    private MQTTOptions mqttOptions;
    @Autowired
    private  SensorServiceImpl sensorService;
    @Autowired
    private  SensorTypeServiceImpl sensorTypeService;


    @Autowired
    private DeviceRepository deviceRepository;
    @Autowired
    private DeviceStateRepository deviceStateRepository;
    @Autowired
    private SensorRepository sensorRepository;


    public ArrayList<String> getAllTopicsOfDevices() {
        ArrayList<String> topics = new ArrayList<>();
        List<Device> devices = deviceRepository.findAll();
        devices.forEach(device -> topics.add(device.getTopic()));
        return topics;
    }

    public ArrayList<String> getAllTopicsOfSensors() {
        ArrayList<String> topics = new ArrayList<>();
        List<Sensor> sensors = sensorRepository.findAll();
        sensors.forEach(sensor ->
        {
            topics.add(sensor.getTopic());
            log.info(sensor.getTopic());
        });
        return topics;
    }
    public ArrayList<MQTTListener> getMqttListeners() {
        ArrayList<MQTTListener> mqttListeners = new ArrayList<>();
        ArrayList<String> topics = getAllTopicsOfDevices();
        topics.addAll(getAllTopicsOfSensors());
        //topics.forEach(topic -> mqttListeners.add(new MQTTListenerIml()));
        topics.forEach(topic -> mqttListeners.add(this));
        return mqttListeners;
    }

    public void сlose() {

    }


    @Override
    public void publishCommand(String command, String payload) {

    }

    @Override
    public void reconfigure(MQTTOptions newOptions, MqttManagerListener listener) {

    }

    @Override
    public void close() throws MqttException {

    }

    @Override
    public void onMQTTConnect() {

    }

    @Override
    public void onMQTTDisconnect() {

    }

    @Override
    public void onMQTTException(String message) {

    }

    @Override
    public void onMQTTMessage(String id, String topic, String payload) {

    }
}
