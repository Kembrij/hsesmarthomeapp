package ru.kembrij.smarthomeapi.service.impl;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import ru.kembrij.smarthomeapi.model.entity.Scheduler;
import ru.kembrij.smarthomeapi.service.SchedulerService;

import java.util.List;


@Service
@AllArgsConstructor

public class SchedulerServiceImpl implements SchedulerService {
    @Override
    public List<Scheduler> findAll() {
        return List.of();
    }

    @Override
    public List<Scheduler> findAllByUserId(Long userId) {
        return List.of();
    }

    @Override
    public Scheduler findById(Long id) {
        return null;
    }

    @Override
    public Scheduler save(Scheduler scheduler) {
        return null;
    }

    @Override
    public void deleteById(Long id) {

    }

    @Override
    public Scheduler update(Scheduler scheduler) {
        return null;
    }
}
