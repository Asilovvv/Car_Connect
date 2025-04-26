package com.example.car_connect.mapper;

import com.example.car_connect.model.domain.User;
import com.example.car_connect.model.dto.auth.AuthRegister;
import com.example.car_connect.model.dto.auth.AuthResponse;

import java.util.UUID;

public interface AuthMapper {
    User toUser(AuthRegister register);
    AuthResponse toResponse(UUID id, String token);
}
