package ru.kembrij.smarthomeapi.controllers;

import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import ru.kembrij.smarthomeapi.dto.DeviceTypeDTO;
import ru.kembrij.smarthomeapi.dto.SensorTypeDTO;
import ru.kembrij.smarthomeapi.service.DeviceTypeService;
import ru.kembrij.smarthomeapi.service.impl.DeviceTypeServiceImpl;

@RestController
@AllArgsConstructor
public class DeviceTypeController {

    private final DeviceTypeServiceImpl deviceTypeService;


    @PostMapping("/create")
    public ResponseEntity<Long> createDeviceType(@RequestBody DeviceTypeDTO deviceTypeDTO) {
        return ResponseEntity.ok(deviceTypeService.save(deviceTypeDTO).getId());
    }

    @PostMapping("/update")
    public ResponseEntity<Long> updateDeviceType(@RequestBody DeviceTypeDTO deviceTypeDTO) {
        return ResponseEntity.ok(deviceTypeService.update(deviceTypeDTO).getId());
    }
}
