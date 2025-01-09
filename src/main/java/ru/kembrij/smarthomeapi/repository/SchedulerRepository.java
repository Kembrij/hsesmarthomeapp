package ru.kembrij.smarthomeapi.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.kembrij.smarthomeapi.model.entity.DeviceType;
import ru.kembrij.smarthomeapi.model.entity.Scheduler;

import java.util.Optional;

@Repository
public interface SchedulerRepository  extends JpaRepository<Scheduler, Long> {

    Optional<Scheduler> findById(Long id);

}
