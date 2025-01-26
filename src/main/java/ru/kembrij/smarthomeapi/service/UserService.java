package ru.kembrij.smarthomeapi.service;

import ru.kembrij.smarthomeapi.model.entity.User;

import java.util.List;

public interface UserService {


    List<User> getAll();

    User findByNickname(String username);

    User findByLogin(String login);

    User findById(Long id);

    void delete(Long id);

    void update(User user);

    User save(User user);

    Long changePassword(User user);

}
