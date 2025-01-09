package ru.kembrij.smarthomeapi.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.kembrij.smarthomeapi.model.entity.Device;
import ru.kembrij.smarthomeapi.model.entity.Scheduler;
import ru.kembrij.smarthomeapi.model.entity.Sensor;
import ru.kembrij.smarthomeapi.model.entity.User;

import java.util.List;
import java.util.Optional;

@Repository
public interface DeviceRepository extends JpaRepository<Device, Long> {


    Optional<Device> findById(Long id);

    List<Device> findAllByUser(User user);

    List<Device> findAllByScheduler(Scheduler scheduler);


}
