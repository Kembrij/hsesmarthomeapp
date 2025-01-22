package ru.kembrij.smarthomeapi.dto;

import jakarta.persistence.Column;
import lombok.Data;
import lombok.ToString;
import ru.kembrij.smarthomeapi.model.entity.enums.TypeOfSensor;

@Data
@ToString
public class SensorTypeDTO {

    private String title;

    private String description;

    private TypeOfSensor typeOfSensor;
}
