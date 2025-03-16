package com.example.car_connect.controller;

import com.example.car_connect.model.dto.user.UserRegister;
import com.example.car_connect.model.dto.user.UserResponse;
import com.example.car_connect.service.MyUserService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@AllArgsConstructor
@RequestMapping("/users")
public class UserController {
    private final MyUserService service;

    @PostMapping("/register")
    public UserResponse register(@RequestBody UserRegister register) {
        return service.register(register);
    }

    @GetMapping("/{id}")
    public UserResponse get(UUID id) {
        return service.get(id);
    }

    @GetMapping("/all")
    public List<UserResponse> all() {
        return service.all();
    }
}
