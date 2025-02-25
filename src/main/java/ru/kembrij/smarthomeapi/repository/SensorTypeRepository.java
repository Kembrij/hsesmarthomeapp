package ru.kembrij.smarthomeapi.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.kembrij.smarthomeapi.model.entity.DeviceType;
import ru.kembrij.smarthomeapi.model.entity.SensorType;

import java.util.Optional;

@Repository
public interface SensorTypeRepository  extends JpaRepository<SensorType, Long> {
    Optional<SensorType> findById(Long id);

}
