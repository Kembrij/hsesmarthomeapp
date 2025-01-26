package ru.kembrij.smarthomeapi.controllers;

import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.kembrij.smarthomeapi.dto.SensorTypeDTO;
import ru.kembrij.smarthomeapi.model.entity.SensorType;
import ru.kembrij.smarthomeapi.service.SensorTypeService;
import ru.kembrij.smarthomeapi.service.impl.SensorTypeServiceImpl;

@RestController
@RequestMapping("/sensortypes")
@AllArgsConstructor
public class SensorTypeController {

    private final SensorTypeServiceImpl sensorTypeService;

    @PostMapping("/create")
    public ResponseEntity<Long> createSensorType(@RequestBody SensorTypeDTO sensorTypeDTO) {
        return ResponseEntity.ok(sensorTypeService.save(sensorTypeDTO).getId());
    }

    @PostMapping("/update")
    public ResponseEntity<Long> updateSensorType(@RequestBody SensorTypeDTO sensorTypeDTO) {
        return ResponseEntity.ok(sensorTypeService.update(sensorTypeDTO).getId());
    }


}
