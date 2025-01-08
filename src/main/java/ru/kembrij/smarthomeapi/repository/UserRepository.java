package ru.kembrij.smarthomeapi.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.kembrij.smarthomeapi.model.entity.User;

import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {

    Optional<User> findByNumberPhone(String numberPhone);

    Optional<User> findByEmail(String email);

    Boolean existsByEmail(String email);

    Boolean existsByNumberPhone(String numberPhone);

}
