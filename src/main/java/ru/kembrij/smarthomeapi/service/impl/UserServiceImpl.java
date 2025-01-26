package ru.kembrij.smarthomeapi.service.impl;

import io.jsonwebtoken.Jwt;
import lombok.AllArgsConstructor;
import lombok.Setter;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import ru.kembrij.smarthomeapi.exceptions.AppException;
import ru.kembrij.smarthomeapi.exceptions.NotFoundException;
import ru.kembrij.smarthomeapi.exceptions.UnauthorizedException;
import ru.kembrij.smarthomeapi.model.entity.User;
import ru.kembrij.smarthomeapi.model.entity.enums.UserRole;
import ru.kembrij.smarthomeapi.repository.SensorRepository;
import ru.kembrij.smarthomeapi.repository.UserRepository;
import ru.kembrij.smarthomeapi.service.UserService;

import java.time.ZonedDateTime;
import java.util.List;
import java.util.Optional;

@Service
@Slf4j
@AllArgsConstructor
public class UserServiceImpl implements UserService {

    private PasswordEncoder passwordEncoder;

    private final UserRepository userRepository;

    private final RefreshTokenServiceImpl refreshTokenService;

    @Override
    public List<User> getAll() {
        return List.of();
    }

    @Override
    public User findByNickname(String username) {
        return null;
    }

    @Override
    public User findById(Long id) {
        return null;
    }
    @Override
    public User findByLogin(String login) {
        return userRepository.findByLoginhash(login);
    }

    @Override
    public void delete(Long id) {

    }

    @Override
    public void update(User user) {

    }

    @Override
    public User save(User user) {
        return null;
    }

    @Override
    public Long changePassword(User user) {
        return 0L;
    }

    public User findByEmail(String email) {
        return userRepository.findByEmail(email);
    }



    public User register(String firstName, String lastName, String nickname, String email, String numberphone, String login, String password) {
        if (findByEmail(email) != null) {
            log.debug(findByEmail(email).toString());
            throw new AppException("Такая электронная почта уже зарегистрирована");
        }
        var user = User.builder()
                .firstname(firstName)
                .lastname(lastName)
                .nickname(nickname)
                .numberphone(numberphone)
                .email(email)
                .loginhash(login)
                .passwordhash(passwordEncoder.encode(password))
                .role(UserRole.USER)
                .build();


        userRepository.save(user);

        return user;
    }

    public Optional<User> getByUsername(String login) {
        var user = userRepository.findByLoginhash(login);
        return user == null ? Optional.empty() : Optional.of(user);
    }

    public ru.kembrij.smarthomeapi.model.entity.Jwt generateJwt(String login, String password) {
        var user = findByLogin(login);
        log.debug(passwordEncoder.encode(password));
        log.debug(user.getPasswordhash());
        if (passwordEncoder.matches(password, user.getPasswordhash())) {
            return refreshTokenService.getTokens(user);
        }
        throw getInvalidCredentialsException();
    }

    private static UnauthorizedException getInvalidCredentialsException() {
        return new UnauthorizedException("Неверный логин или пароль");
    }
}


