package ru.kembrij.smarthomeapi.util;

import io.jsonwebtoken.Claims;
import lombok.experimental.UtilityClass;
import ru.kembrij.smarthomeapi.model.entity.enums.UserRole;
import ru.kembrij.smarthomeapi.security.JwtAuthentication;

@UtilityClass
public final class JwtUtil {

    public static JwtAuthentication generate(Claims claims) {
        var jwtAuthentication = new JwtAuthentication();
        jwtAuthentication.setRole(getRole(claims));
        jwtAuthentication.setUsername(claims.getSubject());
        return jwtAuthentication;
    }

    private static UserRole getRole(Claims claims) {
        var role = claims.get("role", String.class);
        return UserRole.valueOf(role);
    }

}
