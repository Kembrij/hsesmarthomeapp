package ru.kembrij.smarthomeapi.service.impl;

import io.jsonwebtoken.Jwt;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import ru.kembrij.smarthomeapi.exceptions.UnauthorizedException;
import ru.kembrij.smarthomeapi.model.entity.DeviceType;
import ru.kembrij.smarthomeapi.model.entity.RefreshToken;
import ru.kembrij.smarthomeapi.model.entity.User;
import ru.kembrij.smarthomeapi.repository.RefreshTokenRepository;
import ru.kembrij.smarthomeapi.security.JwtTokenProvider;
import ru.kembrij.smarthomeapi.service.RefreshTokenService;


@Service
@AllArgsConstructor
public class RefreshTokenServiceImpl implements RefreshTokenService {


    private final JwtTokenProvider jwtTokenProvider;

    private final RefreshTokenRepository refreshTokenRepository;

    public ru.kembrij.smarthomeapi.model.entity.Jwt  getTokens(User user) {
        var token = refreshTokenRepository.findByUser(user);

        if (token.isPresent()) {
            return updateTokens(token.get());
        }
        var tokens = createTokens(user);
        var refreshToken = RefreshToken.builder()
                .token(tokens.getRefreshToken())
                .user(user)
                .build();
        refreshTokenRepository.save(refreshToken);

        return tokens;
    }

    public ru.kembrij.smarthomeapi.model.entity.Jwt updateTokens(String token) {
        if (!jwtTokenProvider.validateRefreshToken(token)) {
            throw getInvalidRefreshTokenException();
        }
        var refreshToken = refreshTokenRepository.findByToken(token)
                .orElseThrow(() ->getInvalidRefreshTokenException());

        return updateTokens(refreshToken.toString());
    }

    private ru.kembrij.smarthomeapi.model.entity.Jwt updateTokens(RefreshToken token) {
        var tokens = createTokens(token.getUser());
        token.setToken(tokens.getRefreshToken());
        refreshTokenRepository.save(token);
        return tokens;
    }


    private ru.kembrij.smarthomeapi.model.entity.Jwt createTokens(User user) {
        var accessToken = jwtTokenProvider.createAccessToken(user);
        var refreshToken = jwtTokenProvider.createRefreshToken(user);
        return new ru.kembrij.smarthomeapi.model.entity.Jwt(accessToken, refreshToken);
    }

    private static UnauthorizedException getInvalidRefreshTokenException() {
        return new UnauthorizedException("Невалидный refresh токен");
    }
}





