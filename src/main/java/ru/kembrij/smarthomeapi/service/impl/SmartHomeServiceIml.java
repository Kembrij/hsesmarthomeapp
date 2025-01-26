package ru.kembrij.smarthomeapi.service.impl;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import ru.kembrij.smarthomeapi.model.entity.SmartHome;
import ru.kembrij.smarthomeapi.model.entity.User;
import ru.kembrij.smarthomeapi.service.SmartHomeService;


@Service
@AllArgsConstructor

public class SmartHomeServiceIml implements SmartHomeService {
    @Override
    public SmartHome findByUser(User user) {
        return null;
    }

    @Override
    public void save(SmartHome smartHome) {

    }
}
