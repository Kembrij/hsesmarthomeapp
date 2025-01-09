package ru.kembrij.smarthomeapi.service.impl;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import ru.kembrij.smarthomeapi.model.entity.ScheduledDeviceState;
import ru.kembrij.smarthomeapi.service.ScheduledDeviceStateService;

import java.util.List;

@Service
@AllArgsConstructor

public class ScheduledDeviceStateServiceImpl implements
        ScheduledDeviceStateService {
    @Override
    public List<ScheduledDeviceState> findAll() {
        return List.of();
    }

    @Override
    public List<ScheduledDeviceState> findByScheduledDeviceState(ScheduledDeviceState ScheduledDeviceState) {
        return List.of();
    }

    @Override
    public ScheduledDeviceState findById(Long id) {
        return null;
    }

    @Override
    public ScheduledDeviceState save(ScheduledDeviceState scheduledDeviceStatecheduledDeviceState) {
        return null;
    }

    @Override
    public void deleteById(Long id) {

    }

    @Override
    public ScheduledDeviceState update(ScheduledDeviceState scheduledDeviceState) {
        return null;
    }
}
