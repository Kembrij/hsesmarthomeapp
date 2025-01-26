package ru.kembrij.smarthomeapi.controllers;


import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.kembrij.smarthomeapi.dto.CreatedDTO;
import ru.kembrij.smarthomeapi.dto.JwtDTO;
import ru.kembrij.smarthomeapi.dto.LoginDTO;
import ru.kembrij.smarthomeapi.dto.RegistrationDTO;
import ru.kembrij.smarthomeapi.service.UserService;
import ru.kembrij.smarthomeapi.service.impl.RefreshTokenServiceImpl;
import ru.kembrij.smarthomeapi.service.impl.UserServiceImpl;

@RestController
@AllArgsConstructor
@RequestMapping("/auth")
public class AuthenticationController {

    private final ModelMapper modelMapper;

    private final UserServiceImpl userService;

    private RefreshTokenServiceImpl refreshTokenService;

    @PostMapping("/login")
    public ResponseEntity<JwtDTO> login(@RequestBody LoginDTO loginDto) {
        var jwt = userService.generateJwt(loginDto.getLogin(), loginDto.getPassword());
        var jwtDto = modelMapper.map(jwt, JwtDTO.class);
        return ResponseEntity.ok(jwtDto);
    }





}
