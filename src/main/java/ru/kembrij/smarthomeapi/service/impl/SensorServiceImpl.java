package ru.kembrij.smarthomeapi.service.impl;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import ru.kembrij.smarthomeapi.dto.SensorDTO;
import ru.kembrij.smarthomeapi.exceptions.AppException;
import ru.kembrij.smarthomeapi.exceptions.NotFoundException;
import ru.kembrij.smarthomeapi.model.entity.Sensor;
import ru.kembrij.smarthomeapi.repository.*;
import ru.kembrij.smarthomeapi.service.SensorService;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
@Slf4j
public class SensorServiceImpl implements SensorService {

    private final SensorRepository sensorRepository;
    private final SmartHomeRepository smartHomeRepository;
    private final UserRepository userRepository;
    private final AreaRepository areaRepository;
    private final SensorTypeRepository sensorTypeRepository;
    private final SensorDataRepository sensorDataRepository;

    @Override
    public List<Sensor> findAll() {
        return List.of();
    }

    @Override
    public List<Sensor> findAllByUserId(Long userId) {
        return List.of();
    }

    @Override
    public Optional<Sensor> findById(Long id) {
        return Optional.ofNullable(sensorRepository.findById(id).orElseThrow(() -> new NotFoundException("Сенсор ненайден")));
    }

    @Override
    public void deleteById(Long id) {

    }

    @Override
    public Sensor update(Sensor Sensor) {
        return null;
    }

    @Override
    public Sensor save(Sensor Sensor) {
        return null;
    }

    public Sensor findByTopic(String topic) {
        var sensor = sensorRepository.findByTopic(topic).orElseThrow(() -> new NotFoundException("Sensor not found"));
        log.info("Found sensor: {}", sensor.toString());
        return sensor;
    }



    public Sensor save(SensorDTO sensorDTO) {
        if (findByTopic(sensorDTO.getTopic()) == null) {
            throw new AppException("Такой датчик уже есть в базе данных");
        }
        var sensor = Sensor.builder()
                .title(sensorDTO.getTitle())
                .description(sensorDTO.getDescription())
                .user(userRepository.findById(sensorDTO.getUser_id())
                        .orElseThrow(() -> new NotFoundException("Пользователь ненайден")))
                .topic(sensorDTO.getTopic())
                .smartHome(smartHomeRepository.findById(sensorDTO.getSmartHome_id())
                        .orElseThrow(() -> new NotFoundException("Умный дом ненайден")))
                .area(areaRepository.findById(sensorDTO.getArea_id())
                        .orElseThrow(() -> new NotFoundException("Комната ненайдена")))
                .sensorType(sensorTypeRepository.findById(sensorDTO.getSensorType_id()).orElseThrow())
                .sensorData(sensorDataRepository.findById(sensorDTO.getSensorData_id()).orElseThrow())
                .build();
        return sensorRepository.save(sensor);

    }
}
