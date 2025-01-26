package ru.kembrij.smarthomeapi.controllers;


import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.kembrij.smarthomeapi.dto.CreatedDTO;
import ru.kembrij.smarthomeapi.dto.RegistrationDTO;
import ru.kembrij.smarthomeapi.dto.SmartHomeDTO;
import ru.kembrij.smarthomeapi.service.SmartHomeService;
import ru.kembrij.smarthomeapi.service.impl.SmartHomeServiceIml;

@RestController
@RequestMapping("/smarthouses")
@AllArgsConstructor
@Slf4j
public class SmartHomeController {

    private final SmartHomeServiceIml smartHomeService;
    @PostMapping("/add")
    public ResponseEntity<CreatedDTO> registration(@RequestBody SmartHomeDTO smartHomeDTO) {
        log.info(String.valueOf(smartHomeDTO));
        return null;
    }

}
