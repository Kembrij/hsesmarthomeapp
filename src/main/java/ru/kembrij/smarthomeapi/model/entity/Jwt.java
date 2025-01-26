package ru.kembrij.smarthomeapi.model.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

import static lombok.AccessLevel.PROTECTED;

@Data
@Builder
@Accessors(chain = true)
@AllArgsConstructor
@NoArgsConstructor(access = PROTECTED)
public class Jwt {

    private String accessToken;

    private String refreshToken;

}
