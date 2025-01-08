package ru.kembrij.smarthomeapi.repository;

import ru.kembrij.smarthomeapi.model.entity.Sensor;
import ru.kembrij.smarthomeapi.model.entity.User;

import java.util.List;

public interface SensorRepository {

    List<Sensor> findAllByUser(User user);

}
