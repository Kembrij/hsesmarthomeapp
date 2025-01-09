package ru.kembrij.smarthomeapi.controllers;


import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.kembrij.smarthomeapi.model.entity.Device;
import ru.kembrij.smarthomeapi.service.DeviceService;

@RestController
@RequestMapping("/api/devices")
@AllArgsConstructor
public class DeviceController {

    private final DeviceService deviceService;

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Integer> deleteAnswer(@PathVariable("id") Long id) {
        deviceService.deleteById(id);
        return ResponseEntity.ok(1);
    }

    @PostMapping("/create")
    public ResponseEntity<Long> createAnswer(@RequestBody Device device) {
        return ResponseEntity.ok(deviceService.save(device).getId());
    }
}
