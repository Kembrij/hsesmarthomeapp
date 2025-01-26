package ru.kembrij.smarthomeapi.service.impl;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import ru.kembrij.smarthomeapi.dto.DeviceTypeDTO;
import ru.kembrij.smarthomeapi.model.entity.Device;
import ru.kembrij.smarthomeapi.model.entity.DeviceType;
import ru.kembrij.smarthomeapi.service.DeviceTypeService;

import java.util.List;


@Service
@AllArgsConstructor
public class DeviceTypeServiceImpl implements DeviceTypeService {
    @Override
    public List<DeviceType> findAll() {
        return List.of();
    }

    @Override
    public List<DeviceType> findByDevice(Device device) {
        return List.of();
    }

    @Override
    public DeviceType findById(Long id) {
        return null;
    }
    @Override
    public DeviceType save(DeviceTypeDTO deviceTypeDTO) {
        return null;
    }

    @Override
    public void deleteById(Long id) {

    }
    @Override
    public DeviceType update(DeviceTypeDTO deviceTypeDTO) {
        return null;
    }
}
