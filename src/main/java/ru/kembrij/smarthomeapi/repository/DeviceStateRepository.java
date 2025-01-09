package ru.kembrij.smarthomeapi.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.kembrij.smarthomeapi.model.entity.Device;
import ru.kembrij.smarthomeapi.model.entity.DeviceState;

import java.util.Optional;

@Repository
public interface DeviceStateRepository extends JpaRepository<DeviceState, Long> {

    Optional<DeviceState> findById(Long id);

}
