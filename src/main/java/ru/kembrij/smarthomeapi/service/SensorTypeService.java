package ru.kembrij.smarthomeapi.service;

import ru.kembrij.smarthomeapi.dto.SensorTypeDTO;
import ru.kembrij.smarthomeapi.model.entity.Sensor;
import ru.kembrij.smarthomeapi.model.entity.SensorType;

import java.util.List;

public interface SensorTypeService {

    List<SensorType> findAll();

    List<SensorType> findAllBySensorId(Long sensorTypeId);

    Sensor findById(Long id);

    void deleteById(Long id);

    SensorType update(SensorTypeDTO sensorTypeDTO);

    SensorType save(SensorTypeDTO sensorTypeDTO);
}
