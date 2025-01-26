package ru.kembrij.smarthomeapi.model.entity;

import jakarta.persistence.*;
import lombok.*;
import ru.kembrij.smarthomeapi.model.entity.enums.TypeOfSensor;

import java.util.List;


@Builder
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "smart_homes")
@Entity
public class SmartHome {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @SequenceGenerator(name="home_id_generator", sequenceName = "home_seq", allocationSize=50)
    @Column(name = "ID", nullable = false)
    private Long id;

    @Column(name = "TITLE")
    private String title;

    @Column(name = "ADRESS")
    private String adress;

    @ManyToOne(fetch = FetchType.LAZY)
    private User user;

    @Column(name = "areas")
    @OneToMany(fetch = FetchType.LAZY, mappedBy = "smarthome")
    private List<Area> areas;

}
