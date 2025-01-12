package ru.kembrij.smarthomeapi.mqtt;

import org.eclipse.paho.client.mqttv3.MqttException;

public interface MQTTServiceInterface {

    void publishCommand(String command, String payload);

    void reconfigure(MQTTOptions newOptions, MqttManagerListener listener);

    void close() throws MqttException;
}
