package ru.kembrij.smarthomeapi.mqtt;

public interface MqttManagerListener {

    void subscriptionMessage(String id, String topic, String payload);

    void handleMqttException(String errorMessage);

    void handleMqttDisconnected();

    void handleMqttConnected();
}
