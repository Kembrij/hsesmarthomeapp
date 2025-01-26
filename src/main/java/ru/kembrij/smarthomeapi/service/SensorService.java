package ru.kembrij.smarthomeapi.service;

import ru.kembrij.smarthomeapi.model.entity.Sensor;

import java.util.List;
import java.util.Optional;

public interface SensorService {


    List<Sensor> findAll();

    List<Sensor> findAllByUserId(Long userId);

    Optional<Sensor> findById(Long id);

    void deleteById(Long id);

    Sensor update(Sensor Sensor);

    Sensor save(Sensor Sensor);
}
