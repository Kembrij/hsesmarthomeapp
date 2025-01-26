package ru.kembrij.smarthomeapi.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import ru.kembrij.smarthomeapi.model.entity.enums.TypeOfSensor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class DeviceTypeDTO {

    private Long id;

    private String title;

    private String description;

    private TypeOfSensor typeOfSensor;
}
