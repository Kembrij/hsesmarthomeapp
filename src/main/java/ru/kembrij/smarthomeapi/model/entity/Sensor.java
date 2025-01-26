package ru.kembrij.smarthomeapi.model.entity;

import jakarta.persistence.*;
import lombok.*;
import ru.kembrij.smarthomeapi.model.entity.enums.UserRole;


@Getter
@Setter
@ToString
@Builder
@Entity
@Table(name = "sensors")
@NoArgsConstructor
@AllArgsConstructor
public class Sensor {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @SequenceGenerator(name="sensor_id_generator", sequenceName = "sensor_seq", allocationSize=50)
    @Column(name = "ID", nullable = false)
    private Long id;

    @Column(name = "TITLE")
    private String title;

    @Column(name = "DESCRIPTION")
    private String description;

    @ManyToOne(fetch = FetchType.LAZY)
    private User user;

    @Column(name = "TOPIC")
    private String topic;

    @ManyToOne(fetch = FetchType.LAZY)
    private SmartHome smartHome;

    @ManyToOne(fetch = FetchType.LAZY)
    private Area area;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "sensortype_id")
    private SensorType sensorType;

    @OneToOne(fetch = FetchType.LAZY)
    private SensorData sensorData;




}
