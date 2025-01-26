package ru.kembrij.smarthomeapi.service.impl;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import ru.kembrij.smarthomeapi.exceptions.NotFoundException;
import ru.kembrij.smarthomeapi.model.entity.Sensor;
import ru.kembrij.smarthomeapi.model.entity.SensorData;
import ru.kembrij.smarthomeapi.repository.SensorDataRepository;
import ru.kembrij.smarthomeapi.service.SensorDataService;

import java.util.List;

@Service
@AllArgsConstructor
public class SensorDataServiceImpl implements SensorDataService {
    private final SensorDataRepository sensorDataRepository;

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
        return sensorDataRepository.findById(id).orElseThrow(() -> new NotFoundException("Датчик ненайден"));
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

    public SensorData findBySensor(Sensor sensor) {
        var sensorData = sensorDataRepository
                .findBySensor(sensor).orElseThrow(
                        () -> new NotFoundException("Данные такого сенсора необнаружены"));
        return sensorData;
    }


}
