package ru.kembrij.smarthomeapi.model.entity;


import jakarta.persistence.*;
import lombok.*;
import ru.kembrij.smarthomeapi.model.entity.enums.UserRole;

@Getter
@Setter
@ToString
@Builder
@Entity
@Table(name = "users")
@NoArgsConstructor
@AllArgsConstructor
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "ID", nullable = false)
    private Long id;

    @Column(name = "FIRSTNAME")
    private String firstname;

    @Column(name = "LASTNAME")
    private String lastname;

    @Column(name = "NICKNAME")
    private String nickname;

    @Column(name = "EMAIL")
    private String email;

    @Column (name = "NUMBER_PHONE")
    private String numberphone;

    @Column (name = "LOGIN")
    private String loginhash;

    @Column (name = "PASSWORD")
    private String passwordhash;

    @Enumerated(EnumType.STRING)
    private UserRole role;

}
