package ru.kembrij.smarthomeapi.service;

import ru.kembrij.smarthomeapi.model.entity.Sensor;
import ru.kembrij.smarthomeapi.model.entity.SensorData;

import java.util.List;

public interface SensorDataService {

    List<SensorData> findAll();

    List<SensorData> findAllBySensorId(Long sensorId);

    SensorData findById(Long id);

    void deleteById(Long id);

    SensorData update(SensorData sensorData);

    SensorData save(SensorData sensorData);
}
