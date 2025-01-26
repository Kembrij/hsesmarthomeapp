package ru.kembrij.smarthomeapi.dto;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class RegistrationDTO {

    private String firstname;

    private String lastname;

    private String nickname;

    private String email;

    private String numberphone;

    private String login;

    private String password;
}
