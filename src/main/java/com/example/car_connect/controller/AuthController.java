package com.example.car_connect.controller;

import com.example.car_connect.model.dto.auth.AuthLogin;
import com.example.car_connect.model.dto.auth.AuthRegister;
import com.example.car_connect.model.dto.auth.AuthResponse;
import com.example.car_connect.service.AuthService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@AllArgsConstructor
@RequestMapping("/auth")
public class AuthController {
    private final AuthService authService;

    @PostMapping("/register")
    public AuthResponse register(@RequestBody AuthRegister register) {
        return authService.register(register);
    }

    @PostMapping("/login")
    public AuthResponse login(@RequestBody AuthLogin login) {
        return authService.login(login);
    }
}
