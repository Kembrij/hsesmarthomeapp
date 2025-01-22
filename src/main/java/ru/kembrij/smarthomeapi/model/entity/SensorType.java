package ru.kembrij.smarthomeapi.model.entity;

import jakarta.persistence.*;
import lombok.*;
import ru.kembrij.smarthomeapi.model.entity.enums.TypeOfSensor;
import ru.kembrij.smarthomeapi.model.entity.enums.UserRole;


@Getter
@Setter
@ToString
@Entity
@Builder
@Table(name = "sensor_types")
@NoArgsConstructor
@AllArgsConstructor
public class SensorType {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "ID", nullable = false)
    private Long id;

    @Column(name = "TITLE")
    private String title;

    @Column(name = "DESCTIPTION")
    private String description;

    @OneToOne
    @JoinColumn(name = "sensor_id")
    private Sensor sensor;

    @Enumerated(EnumType.STRING)
    private TypeOfSensor type;
}
