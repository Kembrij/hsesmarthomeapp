package ru.kembrij.smarthomeapi.service.impl;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import ru.kembrij.smarthomeapi.model.entity.User;
import ru.kembrij.smarthomeapi.service.UserService;

import java.util.List;

@Service
@AllArgsConstructor
public class UserServiceImpl implements UserService {
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
}
