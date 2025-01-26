package ru.kembrij.smarthomeapi.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.kembrij.smarthomeapi.model.entity.User;

import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {

    Optional<User> findByNickname(String nickname);
    User findByLoginhash(String loginhash);

    Optional<User> findByNumberphone(String numberphone);

    User findByEmail(String email);

    Boolean existsByEmail(String email);

    Boolean existsByNumberphone(String numberphone);

}
