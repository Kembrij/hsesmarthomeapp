package ru.kembrij.smarthomeapi.service.impl;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import ru.kembrij.smarthomeapi.model.entity.SensorData;
import ru.kembrij.smarthomeapi.service.SensorDataService;

import java.util.List;

@Service
@AllArgsConstructor
public class SensorDataServiceImpl implements SensorDataService {
    @Override
    public List<SensorData> findAll() {
        return List.of();
    }

    @Override
    public List<SensorData> findAllBySensorId(Long sensorId) {
        return List.of();
    }

    @Override
    public SensorData findById(Long id) {
        return null;
    }

    @Override
    public void deleteById(Long id) {

    }

    @Override
    public SensorData update(SensorData sensorData) {
        return null;
    }

    @Override
    public SensorData save(SensorData sensorData) {
        return null;
    }
}
