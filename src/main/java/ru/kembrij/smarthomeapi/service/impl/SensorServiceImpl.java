package ru.kembrij.smarthomeapi.service.impl;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import ru.kembrij.smarthomeapi.model.entity.Sensor;
import ru.kembrij.smarthomeapi.service.SensorService;

import java.util.List;

@Service
@AllArgsConstructor
public class SensorServiceImpl implements SensorService {
    @Override
    public List<Sensor> findAll() {
        return List.of();
    }

    @Override
    public List<Sensor> findAllByUserId(Long userId) {
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
    public Sensor update(Sensor Sensor) {
        return null;
    }

    @Override
    public Sensor save(Sensor Sensor) {
        return null;
    }
}
