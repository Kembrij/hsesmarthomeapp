package ru.kembrij.smarthomeapi.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.kembrij.smarthomeapi.model.entity.*;
import ru.kembrij.smarthomeapi.model.entity.enums.DomainOfDevice;

import java.util.List;
import java.util.Optional;

@Repository
public interface DeviceRepository extends JpaRepository<Device, Long> {


    Optional<Device> findById(Long id);

    List<Device> findAll();

    List<Device> findAllByUser(User user);

    List<Device> findAllByScheduler(Scheduler scheduler);
    Optional<Device> findByTopic(String topic);

    List<Device> findDevicesBySmartHome(SmartHome smartHome);

    List<Device> findDevicesByArea(Area area);
    List<Device> findDevicesByDomainAndArea(DomainOfDevice domain, Area area);



}
