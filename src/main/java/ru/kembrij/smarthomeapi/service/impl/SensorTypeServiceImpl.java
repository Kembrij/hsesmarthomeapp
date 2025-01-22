package ru.kembrij.smarthomeapi.service.impl;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import ru.kembrij.smarthomeapi.dto.SensorTypeDTO;
import ru.kembrij.smarthomeapi.model.entity.Sensor;
import ru.kembrij.smarthomeapi.model.entity.SensorType;
import ru.kembrij.smarthomeapi.repository.SensorTypeRepository;
import ru.kembrij.smarthomeapi.service.SensorTypeService;

import java.util.List;

@Service
@AllArgsConstructor

public class SensorTypeServiceImpl implements SensorTypeService {

    private final SensorTypeRepository sensorTypeRepository;

    @Override
    public List<SensorType> findAll() {
        return List.of();
    }

    @Override
    public List<SensorType> findAllBySensorId(Long sensorTypeId) {
        return List.of();
    }

    @Override
    public SensorType getById(Long id) {
        return null;
    }

    @Override
    public void deleteById(Long id) {

    }

    @Override
    public SensorType update(SensorTypeDTO sensorTypeDTO) {
        var sensorType = getById(sensorTypeDTO.getId());
            sensorType.setTitle(sensorTypeDTO.getTitle());
            sensorType.setDescription(sensorTypeDTO.getDescription());
        return sensorTypeRepository.save(sensorType);
    }


    @Override
    public SensorType save(SensorTypeDTO sensorTypeDTO) {
        var sensorType = SensorType.builder()
                .title(sensorTypeDTO.getTitle())
                .description(sensorTypeDTO.getDescription())
                .type(sensorTypeDTO.getTypeOfSensor())
                .build();
        return sensorTypeRepository.save(sensorType);
    }
}
