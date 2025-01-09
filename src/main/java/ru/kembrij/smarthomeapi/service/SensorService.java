package ru.kembrij.smarthomeapi.service;

import ru.kembrij.smarthomeapi.model.entity.Device;
import ru.kembrij.smarthomeapi.model.entity.Sensor;

import java.util.List;

public interface SensorService {

    List<Sensor> findAll();

    List<Sensor> findAllByUserId(Long userId);

    Sensor findById(Long id);

    void deleteById(Long id);

    Sensor update(Sensor Sensor);

    Sensor save(Sensor Sensor);
}
