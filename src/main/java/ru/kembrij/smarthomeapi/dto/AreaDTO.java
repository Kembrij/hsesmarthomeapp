package ru.kembrij.smarthomeapi.dto;

import ru.kembrij.smarthomeapi.model.entity.Area;
import ru.kembrij.smarthomeapi.model.entity.SmartHome;
import ru.kembrij.smarthomeapi.model.entity.User;

import java.util.List;

public class AreaDTO {

    private String title;

    private SmartHome smartHome;

    private List<Area> areas;

    private User user;

}
