package ru.kembrij.smarthomeapi.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.kembrij.smarthomeapi.model.entity.DeviceState;
import ru.kembrij.smarthomeapi.model.entity.DeviceType;

import java.util.Optional;

@Repository
public interface DeviceTypeRepository extends JpaRepository<DeviceType, Long> {

    Optional<DeviceType> findById(Long id);

}
