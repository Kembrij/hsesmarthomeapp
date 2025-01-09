package ru.kembrij.smarthomeapi.service.impl;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import ru.kembrij.smarthomeapi.model.entity.Sensor;
import ru.kembrij.smarthomeapi.model.entity.SensorType;
import ru.kembrij.smarthomeapi.service.SensorTypeService;

import java.util.List;

@Service
@AllArgsConstructor

public class SensorTypeServiceImpl implements SensorTypeService {
    @Override
    public List<SensorType> findAll() {
        return List.of();
    }

    @Override
    public List<SensorType> findAllBySensorId(Long sensorTypeId) {
        return List.of();
    }

    @Override
    public Sensor findById(Long id) {
        return null;
    }

    @Override
    public void deleteById(Long id) {

    }

    @Override
    public SensorType update(SensorType sensorType) {
        return null;
    }

    @Override
    public SensorType save(SensorType sensorType) {
        return null;
    }
}
