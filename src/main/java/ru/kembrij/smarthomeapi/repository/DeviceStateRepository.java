package ru.kembrij.smarthomeapi.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.kembrij.smarthomeapi.exceptions.NotFoundException;
import ru.kembrij.smarthomeapi.model.entity.Device;
import ru.kembrij.smarthomeapi.model.entity.DeviceState;
import ru.kembrij.smarthomeapi.model.entity.Sensor;
import ru.kembrij.smarthomeapi.model.entity.SensorData;

import java.util.Optional;

@Repository
public interface DeviceStateRepository extends JpaRepository<DeviceState, Long> {

    Optional<DeviceState> findById(Long id);

    Optional<DeviceState> findByDevice(Device device);
}