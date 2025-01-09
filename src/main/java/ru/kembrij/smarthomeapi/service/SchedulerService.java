package ru.kembrij.smarthomeapi.service;

import ru.kembrij.smarthomeapi.model.entity.Device;
import ru.kembrij.smarthomeapi.model.entity.Scheduler;

import java.util.List;

public interface SchedulerService {


    List<Scheduler> findAll();

    List<Scheduler> findAllByUserId(Long userId);

    Scheduler findById(Long id);

    Scheduler save(Scheduler scheduler);

    void deleteById(Long id);

    Scheduler update(Scheduler scheduler);


}
