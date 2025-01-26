package ru.kembrij.smarthomeapi.controllers;

import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.modelmapper.ModelMapper;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.*;
import ru.kembrij.smarthomeapi.dto.CreatedDTO;
import ru.kembrij.smarthomeapi.dto.RegistrationDTO;
import ru.kembrij.smarthomeapi.service.UserService;
import ru.kembrij.smarthomeapi.service.impl.UserServiceImpl;

import java.util.List;

@RestController
@AllArgsConstructor
@Slf4j
public class UserController {


    private final ModelMapper modelMapper;

    private final UserServiceImpl userService;

    @PostMapping("/register")
    public ResponseEntity<CreatedDTO> registration(@RequestBody RegistrationDTO registrationDTO) {
        log.info(String.valueOf(registrationDTO));
        var user = userService.register(registrationDTO.getFirstname(),
                registrationDTO.getLastname(),
                registrationDTO.getNickname(),
                registrationDTO.getEmail(),
                registrationDTO.getNumberphone(),
                registrationDTO.getLogin(),
                registrationDTO.getPassword());

        var userCreatedDTO = new CreatedDTO(userService.findByEmail(registrationDTO.getEmail()).getId());

        return new ResponseEntity<>(userCreatedDTO, HttpStatus.CREATED);
    }

    @GetMapping("/test")
    public ResponseEntity<String> getAllTestTablesTwo() {
        String str = "Test";
        return new ResponseEntity<String>(HttpStatus.OK);
    }


}
