package ru.kembrij.smarthomeapi.service;

import ru.kembrij.smarthomeapi.dto.DeviceTypeDTO;
import ru.kembrij.smarthomeapi.model.entity.Device;
import ru.kembrij.smarthomeapi.model.entity.DeviceState;
import ru.kembrij.smarthomeapi.model.entity.DeviceType;

import java.util.List;

public interface DeviceTypeService {

    List<DeviceType> findAll();

    List<DeviceType> findByDevice(Device device);

    DeviceType findById(Long id);

    DeviceType save(DeviceTypeDTO deviceTypeDTO);

    void deleteById(Long id);

    DeviceType update(DeviceTypeDTO deviceTypeDTO);
}
