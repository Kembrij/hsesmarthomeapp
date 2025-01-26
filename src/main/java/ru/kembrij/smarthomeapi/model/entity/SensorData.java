package ru.kembrij.smarthomeapi.model.entity;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;


@Getter
@Setter
@ToString
@Entity
@Builder
@Table(name = "sensor_data")
@NoArgsConstructor
@AllArgsConstructor
public class SensorData {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @SequenceGenerator(name="sensordata_id_generator", sequenceName = "sensordata_seq", allocationSize=50)
    @Column(name = "ID", nullable = false)
    private Long id;

    @Column(name = "TIMESTAMP", nullable = false)
    private LocalDateTime timestamp;

    @Column(name = "DATA")
    private String data;

    @ManyToOne(fetch = FetchType.LAZY)
    private Sensor sensor;
}
