package ru.kembrij.smarthomeapi.service.impl;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import ru.kembrij.smarthomeapi.model.entity.Device;
import ru.kembrij.smarthomeapi.model.entity.DeviceState;
import ru.kembrij.smarthomeapi.repository.DeviceStateRepository;
import ru.kembrij.smarthomeapi.service.DeviceStateService;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class DeviceStateServiceImpl implements DeviceStateService {

    private final DeviceStateRepository deviceStateRepository;

    @Override
    public List<DeviceState> findAll() {
        return List.of();
    }

    @Override
    public List<DeviceState> findALLDeviceStateByDevice(Device device) {
        return List.of();
    }

    public Optional<DeviceState> findByDevice(Device device) {
        return deviceStateRepository.findByDevice(device);
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
        var device = findById(deviceState.getId());
        device.setState(deviceState.getState());
        return deviceStateRepository.save(device);
    }
}
