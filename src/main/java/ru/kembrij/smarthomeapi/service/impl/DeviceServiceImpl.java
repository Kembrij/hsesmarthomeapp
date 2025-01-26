package ru.kembrij.smarthomeapi.service.impl;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import ru.kembrij.smarthomeapi.exceptions.NotFoundException;
import ru.kembrij.smarthomeapi.model.entity.Device;
import ru.kembrij.smarthomeapi.model.entity.Sensor;
import ru.kembrij.smarthomeapi.repository.DeviceRepository;
import ru.kembrij.smarthomeapi.service.DeviceService;

import java.util.List;

@Service
@AllArgsConstructor
@Slf4j
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

    public Device findByTopic(String topic) {
        var device = deviceRepository.findByTopic(topic).orElseThrow(() -> new NotFoundException("Device not found"));
        return device;
    }
}
