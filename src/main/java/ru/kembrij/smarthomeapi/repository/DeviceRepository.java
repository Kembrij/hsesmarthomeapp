package ru.kembrij.smarthomeapi.repository;

import ru.kembrij.smarthomeapi.model.entity.Device;
import ru.kembrij.smarthomeapi.model.entity.Scheduler;
import ru.kembrij.smarthomeapi.model.entity.User;

import java.util.List;

public interface DeviceRepository {

    List<Device> findAllByUser(User user);

    List<Device> findAllByScheduler(Scheduler scheduler);


}
