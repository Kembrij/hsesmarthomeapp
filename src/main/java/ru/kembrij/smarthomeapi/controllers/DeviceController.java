package ru.kembrij.smarthomeapi.controllers;


import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.kembrij.smarthomeapi.dto.DeviceDTO;
import ru.kembrij.smarthomeapi.dto.DeviceStateDTO;
import ru.kembrij.smarthomeapi.model.entity.Device;
import ru.kembrij.smarthomeapi.repository.DeviceRepository;
import ru.kembrij.smarthomeapi.service.DeviceService;
import ru.kembrij.smarthomeapi.service.DeviceStateService;
import ru.kembrij.smarthomeapi.service.impl.DeviceStateServiceImpl;

@RestController
@RequestMapping("/devices")
@AllArgsConstructor
public class DeviceController {

    private final DeviceService deviceService;
    private final ModelMapper modelMapper;
    private final DeviceStateServiceImpl deviceStateService;

    @GetMapping("/{id}")
    public ResponseEntity<DeviceDTO> getById(@PathVariable Long id) {
        var device = deviceService.findById(id);
        var deviceDTO = modelMapper.map(device, DeviceDTO.class);
        return ResponseEntity.ok(deviceDTO);
    }
    @GetMapping("/{id}/devicestate")
    public ResponseEntity<DeviceStateDTO> getDeviceStateByDeviceId(@PathVariable Long id) {
        var deviceState = deviceStateService.findById(id);
        var deviceDTO = modelMapper.map(deviceState, DeviceStateDTO.class);
        return ResponseEntity.ok(deviceDTO);
    }

}
