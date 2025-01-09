package ru.kembrij.smarthomeapi.service.impl;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import ru.kembrij.smarthomeapi.model.entity.Device;
import ru.kembrij.smarthomeapi.model.entity.DeviceState;
import ru.kembrij.smarthomeapi.service.DeviceStateService;

import java.util.List;

@Service
@AllArgsConstructor
public class DeviceStateServiceImpl implements DeviceStateService {
    @Override
    public List<DeviceState> findAll() {
        return List.of();
    }

    @Override
    public List<DeviceState> findByDevice(Device device) {
        return List.of();
    }

    @Override
    public DeviceState findById(Long id) {
        return null;
    }

    @Override
    public DeviceState save(Device device) {
        return null;
    }

    @Override
    public void deleteById(Long id) {

    }

    @Override
    public DeviceState update(DeviceState deviceState) {
        return null;
    }
}
