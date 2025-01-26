package ru.kembrij.smarthomeapi.model.entity;


import jakarta.persistence.*;
import lombok.*;

@Getter
@Setter
@ToString
@Entity
@Builder
@Table(name = "STATE_OF_DEVICES")
@NoArgsConstructor
@AllArgsConstructor
public class DeviceState {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "ID", nullable = false)
    private Long id;

    @Column(name = "STATE")
    private String state;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "DEVICE_ID")
    private Device device;


}
