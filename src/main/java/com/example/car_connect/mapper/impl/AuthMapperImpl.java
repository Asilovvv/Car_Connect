package com.example.car_connect.mapper.impl;

import com.example.car_connect.mapper.AuthMapper;
import com.example.car_connect.model.domain.User;
import com.example.car_connect.model.dto.auth.AuthRegister;
import com.example.car_connect.model.dto.auth.AuthResponse;
import com.example.car_connect.model.enums.Role;
import org.springframework.stereotype.Component;

import java.util.UUID;

@Component
public class AuthMapperImpl implements AuthMapper {
    @Override
    public User toUser(AuthRegister register) {
        User user = new User();
        user.setName(register.getName());
        user.setEmail(register.getEmail());
        user.setPassword(register.getPassword());
        user.setRole(Role.valueOf(register.getRole()));
        return user;
    }

    @Override
    public AuthResponse toResponse(UUID id, String token) {
        AuthResponse response = new AuthResponse();
        response.setId(id);
        response.setToken(token);
        return response;
    }
}
