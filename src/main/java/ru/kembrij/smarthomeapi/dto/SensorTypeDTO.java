package ru.kembrij.smarthomeapi.dto;

import jakarta.persistence.Column;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import ru.kembrij.smarthomeapi.model.entity.enums.TypeOfSensor;

@Data
@AllArgsConstructor
@NoArgsConstructor(force = true)
public class SensorTypeDTO {

    private Long id;

    private String title;

    private String description;

    private TypeOfSensor typeOfSensor;
}
