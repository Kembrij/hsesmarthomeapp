package ru.kembrij.smarthomeapi.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.kembrij.smarthomeapi.model.entity.SmartHome;

public interface SmartHomeRepository extends JpaRepository<SmartHome, Long> {
}
