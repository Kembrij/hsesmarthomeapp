package ru.kembrij.smarthomeapi.model.entity;


import jakarta.persistence.*;
import lombok.*;

@Getter
@Setter
@ToString
@Builder
@Entity
@Table(name = "SCHEDULED_STATES_OF_DEVICES")
@NoArgsConstructor
@AllArgsConstructor
public class ScheduledDeviceState {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @SequenceGenerator(name="schdev_id_generator", sequenceName = "schdev_seq", allocationSize=50)
    @Column(name = "STATE")
    private String state;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "DEVICE_ID")
    private Device device;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "SCHEDULER_ID")
    private Scheduler scheduler;

}
