package ru.kembrij.smarthomeapi.mqtt;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.eclipse.paho.client.mqttv3.IMqttMessageListener;
import org.eclipse.paho.client.mqttv3.MqttMessage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import ru.kembrij.smarthomeapi.model.entity.Sensor;
import ru.kembrij.smarthomeapi.service.impl.SensorServiceImpl;
import ru.kembrij.smarthomeapi.service.impl.SensorTypeServiceImpl;

import java.util.ArrayList;

@Component
@AllArgsConstructor
@Slf4j
public class MQTTListenerIml implements MQTTListener, IMqttMessageListener {


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

    @Override
    public void messageArrived(String s, MqttMessage mqttMessage) throws Exception {
        log.info("Сообщение MQTT получено: {}", new String(mqttMessage.getPayload()));
        log.info("Строка: {}", s);
    }

    public ArrayList<MQTTListenerIml> getListeners(ArrayList<String> topics) {
        ArrayList<MQTTListenerIml> mqttListeners = new ArrayList<>();
        topics.forEach(topic -> {
            mqttListeners.add(new MQTTListenerIml());
        });
        return mqttListeners;
    }
}