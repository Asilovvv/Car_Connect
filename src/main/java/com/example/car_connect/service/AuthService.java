package com.example.car_connect.service;

import com.example.car_connect.model.dto.auth.AuthLogin;
import com.example.car_connect.model.dto.auth.AuthRegister;
import com.example.car_connect.model.dto.auth.AuthResponse;

public interface AuthService {
    AuthResponse register(AuthRegister register);
    AuthResponse login(AuthLogin login);
}
