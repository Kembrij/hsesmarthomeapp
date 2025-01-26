package ru.kembrij.smarthomeapi.controllers;

import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.kembrij.smarthomeapi.dto.CreatedDTO;
import ru.kembrij.smarthomeapi.dto.DeviceDTO;
import ru.kembrij.smarthomeapi.dto.SensorDTO;
import ru.kembrij.smarthomeapi.model.entity.Sensor;
import ru.kembrij.smarthomeapi.model.entity.SensorData;
import ru.kembrij.smarthomeapi.service.SensorDataService;
import ru.kembrij.smarthomeapi.service.SensorService;
import ru.kembrij.smarthomeapi.service.UserService;
import ru.kembrij.smarthomeapi.service.impl.SensorServiceImpl;

@RestController
@AllArgsConstructor
@RequestMapping("/sensors")
public class SensorController {

    private final SensorServiceImpl sensorService;
    private final ModelMapper modelMapper;
    private final SensorDataService sensorDataService;

    @GetMapping("/{id}")
    public ResponseEntity<SensorDTO> getById(@PathVariable Long id) {
        var sensor = sensorService.findById(id);
        var sensorDTO = modelMapper.map(sensor, SensorDTO.class);
        return ResponseEntity.ok(sensorDTO);
    }

    @PostMapping("/add")
    public ResponseEntity<CreatedDTO> getById(@RequestBody SensorDTO sensorDTO) {
        var sensor = sensorService.save(sensorDTO);
        var createdDTO = new CreatedDTO(sensorService.findByTopic(sensorDTO.getTopic()).getId());
        return new ResponseEntity<>(createdDTO, HttpStatus.CREATED);
    }
}

