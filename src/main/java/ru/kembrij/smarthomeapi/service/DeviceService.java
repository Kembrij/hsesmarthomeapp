package ru.kembrij.smarthomeapi.service;

import ru.kembrij.smarthomeapi.model.entity.Device;

import java.util.List;
import java.util.concurrent.ScheduledExecutorService;

public interface DeviceService {

    List<Device> findAll();

    List<Device> findAllByUserId(Long userId);

    Device findById(Long id);

    Device save(Device device);

    void deleteById(Long id);

    Device update(Device device);



}
