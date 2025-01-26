package ru.kembrij.smarthomeapi.dto;

import jakarta.persistence.Column;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import ru.kembrij.smarthomeapi.model.entity.enums.UserRole;

@Data
@AllArgsConstructor
@NoArgsConstructor(force = true)
public class UserDTO {

    private Long id;

    private String firstname;

    private String lastname;

    private String nickname;

    private String email;

    private String numberphone;

    private UserRole role;
}
