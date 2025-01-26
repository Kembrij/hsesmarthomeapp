package ru.kembrij.smarthomeapi.dto;

import jakarta.persistence.FetchType;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import lombok.*;
import ru.kembrij.smarthomeapi.model.entity.*;

@Data
@Builder
@Getter
@AllArgsConstructor
public class SensorDTO {

    private String title;

    private String description;

    private Long user_id;

    private String topic;

    private Long smartHome_id;

    private Long area_id;

    private Long sensorType_id;

    private Long sensorData_id;

}
