package ru.kembrij.smarthomeapi.service;

import ru.kembrij.smarthomeapi.model.entity.Area;
import ru.kembrij.smarthomeapi.model.entity.SmartHome;
import ru.kembrij.smarthomeapi.model.entity.User;

public interface AreaService {

    Area findByUser(User user);

    Area findBySmartHome(SmartHome smartHome);
}
