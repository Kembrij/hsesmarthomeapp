package ru.kembrij.smarthomeapi.service;

import ru.kembrij.smarthomeapi.model.entity.SmartHome;
import ru.kembrij.smarthomeapi.model.entity.User;

public interface SmartHomeService {

    SmartHome  findByUser(User user);

    void save(SmartHome smartHome);
}
