package com.example.car_connect.mapper.impl;

import com.example.car_connect.mapper.UserMapper;
import com.example.car_connect.model.domain.User;
import com.example.car_connect.model.dto.user.OwnerRequest;
import com.example.car_connect.model.dto.user.OwnerResponse;
import com.example.car_connect.model.dto.user.UserRegister;
import com.example.car_connect.model.dto.user.UserResponse;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class UserMapperImpl implements UserMapper {
    @Override
    public User toUser(User user, OwnerRequest request) {
        user.setName(request.getName());
        user.setPhone(request.getPhone());
        return user;
    }

    @Override
    public User toUser(UserRegister register) {
        User user = new User();
        user.setName(register.getName());
        user.setEmail(register.getEmail());
        user.setPassword(register.getPassword());
        user.setPhone(register.getPhone());
        return user;
    }

    @Override
    public UserResponse toResponse(User user) {
        UserResponse userResponse = new UserResponse();
        userResponse.setId(user.getId());
        userResponse.setName(user.getName());
        userResponse.setEmail(user.getEmail());
        userResponse.setPhone(user.getPhone());
        return userResponse;
    }

    @Override
    public List<UserResponse> toResponses(List<User> users) {
        List<UserResponse> responses = new ArrayList<>();
        for (User user : users) {
            responses.add(toResponse(user));
        }
        return responses;
    }

    @Override
    public OwnerResponse toOwnerResponse(User user) {
        OwnerResponse response = new OwnerResponse();
        response.setName(user.getName());
        return response;
    }

    @Override
    public List<OwnerResponse> toOwnerResponses(List<User> users) {
        List<OwnerResponse> responses = new ArrayList<>();
        for (User user : users) {
            responses.add(toOwnerResponse(user));
        }
        return responses;
    }
}
