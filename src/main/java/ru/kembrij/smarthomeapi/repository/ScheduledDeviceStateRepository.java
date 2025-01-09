package ru.kembrij.smarthomeapi.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.kembrij.smarthomeapi.model.entity.DeviceType;
import ru.kembrij.smarthomeapi.model.entity.ScheduledDeviceState;

import java.util.Optional;

@Repository
public interface ScheduledDeviceStateRepository  extends
        JpaRepository<ScheduledDeviceState, Long> {

    Optional<ScheduledDeviceState> findById(Long id);

}
