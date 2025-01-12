package ru.kembrij.smarthomeapi.controllers;

import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.kembrij.smarthomeapi.service.UserService;

@RestController
@RequestMapping("/api/users")
public class UserController {

    //private final BCryptPasswordEncoder encoder;


}
