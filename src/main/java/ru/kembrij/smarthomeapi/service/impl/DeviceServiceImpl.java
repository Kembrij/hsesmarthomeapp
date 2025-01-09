package ru.kembrij.smarthomeapi.service.impl;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import ru.kembrij.smarthomeapi.model.entity.Device;
import ru.kembrij.smarthomeapi.repository.DeviceRepository;
import ru.kembrij.smarthomeapi.service.DeviceService;

import java.util.List;

@Service
@AllArgsConstructor
public class DeviceServiceImpl implements DeviceService {

    private final DeviceRepository deviceRepository;

    @Override
    public List<Device> findAll() {
        return List.of();
    }

    @Override
    public List<Device> findAllByUserId(Long userId) {
        return List.of();
    }

    @Override
    public Device findById(Long id) {
        return null;
    }

    @Override
    public Device save(Device device) {
        return null;
    }

    @Override
    public void deleteById(Long id) {

    }

    @Override
    public Device update(Device device) {
        return null;
    }
}
