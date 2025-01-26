package ru.kembrij.smarthomeapi.model.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

import static lombok.AccessLevel.PROTECTED;

@Data
@Builder
@AllArgsConstructor
@Accessors(chain = true)
@NoArgsConstructor(access = PROTECTED)
@Entity(name = "refresh_token")
public class RefreshToken {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @SequenceGenerator(name="area_id_generator", sequenceName = "area_seq", allocationSize=50)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

    private String token;

}