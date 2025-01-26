package ru.kembrij.smarthomeapi.dto;

import jakarta.persistence.Column;
import jakarta.persistence.FetchType;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import ru.kembrij.smarthomeapi.model.entity.Area;
import ru.kembrij.smarthomeapi.model.entity.User;

import java.util.List;

public class SmartHomeDTO {

    private String title;

    private String adress;

    private User user;

    private List<Area> areas;
}
