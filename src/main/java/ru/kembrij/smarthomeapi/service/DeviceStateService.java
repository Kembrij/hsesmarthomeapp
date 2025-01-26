package ru.kembrij.smarthomeapi.service;

import ru.kembrij.smarthomeapi.model.entity.Device;
import ru.kembrij.smarthomeapi.model.entity.DeviceState;

import java.util.List;

public interface DeviceStateService {

    List<DeviceState> findAll();

    List<DeviceState> findALLDeviceStateByDevice(Device device);

    DeviceState findById(Long id);

    DeviceState save(Device device);

    void deleteById(Long id);

    DeviceState update(DeviceState deviceState);
}
