package ru.kembrij.smarthomeapi.model.entity;


import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Getter
@Setter
@Data
@ToString
@Entity
@Table(name = "devices")
@NoArgsConstructor
public class Device {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "ID", nullable = false)
    private Long id;

    @Column(name = "TITLES")
    private String title;

    @Column(name = "SCHEDULER")
    private Scheduler scheduler;

    @Column(name = "DESCRIPTION")
    private String description;

    @ManyToOne(fetch = FetchType.LAZY)
    private User user;

    @OneToOne(fetch = FetchType.LAZY)
    private DeviceType deviceType;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "device")
    private List<ScheduledDeviceState> scheduledDeviceStates;
}
