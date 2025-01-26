package ru.kembrij.smarthomeapi.service.impl;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import ru.kembrij.smarthomeapi.model.entity.Area;
import ru.kembrij.smarthomeapi.model.entity.SmartHome;
import ru.kembrij.smarthomeapi.model.entity.User;
import ru.kembrij.smarthomeapi.service.AreaService;


@Service
@AllArgsConstructor
public class AreaServiceIml implements AreaService {
    @Override
    public Area findByUser(User user) {
        return null;
    }

    @Override
    public Area findBySmartHome(SmartHome smartHome) {
        return null;
    }
}
