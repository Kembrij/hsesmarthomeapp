package ru.kembrij.smarthomeapi.service;

import ru.kembrij.smarthomeapi.model.entity.Device;
import ru.kembrij.smarthomeapi.model.entity.DeviceState;
import ru.kembrij.smarthomeapi.model.entity.ScheduledDeviceState;

import java.util.List;

public interface ScheduledDeviceStateService {

    List<ScheduledDeviceState> findAll();

    List<ScheduledDeviceState> findByScheduledDeviceState(
            ScheduledDeviceState ScheduledDeviceState);

    ScheduledDeviceState findById(Long id);

    ScheduledDeviceState save(ScheduledDeviceState scheduledDeviceStatecheduledDeviceState);

    void deleteById(Long id);

    ScheduledDeviceState update(ScheduledDeviceState scheduledDeviceState);
}
