package ru.kembrij.smarthomeapi.dto;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import ru.kembrij.smarthomeapi.model.entity.DeviceType;
import ru.kembrij.smarthomeapi.model.entity.ScheduledDeviceState;
import ru.kembrij.smarthomeapi.model.entity.Scheduler;
import ru.kembrij.smarthomeapi.model.entity.User;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor(force = true)
public class DeviceDTO {

    private Long id;

    private String title;

    private String description;

    private String smartHomeName;

    private String smartAreaName;

    private DeviceType deviceType;

}
