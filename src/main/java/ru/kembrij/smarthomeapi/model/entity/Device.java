package ru.kembrij.smarthomeapi.model.entity;


import jakarta.persistence.*;
import lombok.*;
import ru.kembrij.smarthomeapi.model.entity.enums.DomainOfDevice;
import ru.kembrij.smarthomeapi.model.entity.enums.UserRole;

import java.util.List;

@Getter
@Setter
@Data
@ToString
@Builder
@Entity
@Table(name = "devices")
@NoArgsConstructor
@AllArgsConstructor
public class Device {


    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @SequenceGenerator(name="device_id_generator", sequenceName = "device_seq", allocationSize=50)
    @Column(name = "ID", nullable = false)
    private Long id;

    @Column(name = "TITLES")
    private String title;

    @Column(name = "SCHEDULER")
    @OneToMany(fetch = FetchType.LAZY, mappedBy = "device")
    private List<Scheduler> scheduler;

    @Column(name = "DESCRIPTION")
    private String description;

    @Column(name = "TOPIC")
    private String topic;

    @ManyToOne(fetch = FetchType.LAZY)
    private User user;

    @ManyToOne(fetch = FetchType.LAZY)
    private SmartHome smartHome;

    @ManyToOne(fetch = FetchType.LAZY)
    private Area area;

    @OneToOne(fetch = FetchType.LAZY)
    private DeviceType deviceType;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "device")
    private List<ScheduledDeviceState> scheduledDeviceStates;

    @Enumerated(EnumType.STRING)
    private DomainOfDevice domain;
}
