package ru.kembrij.smarthomeapi.model.entity;


import jakarta.persistence.*;
import lombok.*;

import java.io.Serializable;
import java.time.Duration;
import java.time.LocalDateTime;

@Getter
@Setter
@ToString
@Data
@Entity
@Table(name = "schedulers")
@NoArgsConstructor
public class Scheduler implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "ID", nullable = false)
    private Long id;

    @Column(name = "ISACTIVE")
    private Boolean isActive;

    @Column(name = "DATEOFCREATION", nullable = false)
    private LocalDateTime dateOfCreation;

    @Column(name = "TITLE")
    private String title;

    @Column(name = "DESCTIPTION")
    private String description;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "DEVICE_ID")
    private Device device;

    @Column(name ="DATEOFSTART")
    private Boolean dateOfStart;

    @Column(name = "DATESCHEDULERSTARTON")
    private LocalDateTime dateSchedulerStartOn;

    @Column(name = "DATESCHEDULERSTARTOFF")
    private LocalDateTime dateSchedulerStartOff;

    @Column(name = "DURATION")
    private Duration duration;

    @Column(name = "DATEDURATIONTARTON")
    private LocalDateTime dateDurationStartOn;

    @Column(name = "DATEDURATIONTARTOFF")
    private LocalDateTime dateDurationStartOff;

    @Column(name = "WEEKLYMONDAY")
    private Boolean weeklyMonday;

    @Column(name = "WEEKLYTUESDAY")
    private Boolean weeklyTuesday;

    @Column(name = "WEEKLYWEDNESDAY")
    private Boolean weeklyWednesday;

    @Column(name = "WEEKLYTHURSDAY")
    private Boolean weeklyThursday;

    @Column(name = "WEEKLYFRIDAY")
    private Boolean weeklyFriday;

    @Column(name = "WEEKLYSATURDAY")
    private Boolean weeklySaturday;

    @Column(name = "WEEKLYSUNDAY")
    private Boolean weeklySunday;

}
