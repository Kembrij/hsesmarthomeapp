package ru.kembrij.smarthomeapi.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.kembrij.smarthomeapi.model.entity.Area;
import ru.kembrij.smarthomeapi.model.entity.SmartHome;
import ru.kembrij.smarthomeapi.model.entity.User;

import java.util.List;
import java.util.Optional;

public interface AreaRepository extends JpaRepository<Area, Long> {

    List<Area> findByUser(User user);

    List<Area> findBySmarthome(SmartHome smarthome);
    Optional<Area> findById(Long id);
}
