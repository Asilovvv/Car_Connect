package com.example.car_connect.service;

import com.example.car_connect.model.dto.user.UserRegister;
import com.example.car_connect.model.dto.user.UserResponse;

import java.util.List;
import java.util.UUID;

public interface MyUserService {
    UserResponse register(UserRegister register);
    UserResponse get(UUID id);
    List<UserResponse> all();

}
