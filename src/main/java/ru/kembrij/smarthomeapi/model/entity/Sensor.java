package ru.kembrij.smarthomeapi.model.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import ru.kembrij.smarthomeapi.model.entity.enums.UserRole;


@Getter
@Setter
@ToString
@Entity
@Table(name = "sensors")
@NoArgsConstructor
public class Sensor {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "ID", nullable = false)
    private Long id;

    @Column(name = "TITLE")
    private String title;

    @Column(name = "DESCRIPTION")
    private String description;

    @ManyToOne(fetch = FetchType.LAZY)
    private User user;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "sensortype_id")
    private SensorType sensorType;

    @OneToOne(fetch = FetchType.LAZY)
    private SensorData sensorData;




}
