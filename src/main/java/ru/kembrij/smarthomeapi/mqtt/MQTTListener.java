package ru.kembrij.smarthomeapi.mqtt;

import org.springframework.stereotype.Component;

@Component
public interface MQTTListener {

    void onMQTTConnect();

    void onMQTTDisconnect();

    void onMQTTException(String message);

    void onMQTTMessage(String id, String topic, String payload);


}
