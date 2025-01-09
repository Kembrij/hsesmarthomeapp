package ru.kembrij.smarthomeapi.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.kembrij.smarthomeapi.model.entity.DeviceType;
import ru.kembrij.smarthomeapi.model.entity.SensorData;

import java.util.Optional;

@Repository
public interface SensorDataRepository  extends JpaRepository<SensorData, Long> {

    Optional<SensorData> findById(Long id);

}
