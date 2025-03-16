package com.example.car_connect.service.impl;

import com.example.car_connect.exception.CustomException;
import com.example.car_connect.mapper.UserMapper;
import com.example.car_connect.model.dto.user.UserRegister;
import com.example.car_connect.model.dto.user.UserResponse;
import com.example.car_connect.repository.UserRepository;
import com.example.car_connect.service.MyUserService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
@AllArgsConstructor
public class MyUserServiceImpl implements MyUserService {
    private final UserRepository userRepository;
    private final UserMapper userMapper;

    @Override
    public UserResponse register(UserRegister register) {
        return userMapper.toResponse(userRepository.save(userMapper.toUser(register)));
    }

    @Override
    public UserResponse get(UUID id) {
        return userMapper.toResponse(userRepository.findById(id).orElseThrow(() -> new CustomException("User not found", HttpStatus.NOT_FOUND)));
    }

    @Override
    public List<UserResponse> all() {
        return userMapper.toResponses(userRepository.findAll());
    }
}
