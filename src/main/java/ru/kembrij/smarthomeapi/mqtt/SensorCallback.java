package ru.kembrij.smarthomeapi.mqtt;

import com.fasterxml.jackson.databind.JsonNode;

public interface SensorCallback {
    void publishSensorData(String sensorName, JsonNode sensorData);
}

