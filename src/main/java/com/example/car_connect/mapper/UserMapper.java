package com.example.car_connect.mapper;

import com.example.car_connect.model.domain.User;
import com.example.car_connect.model.dto.user.OwnerRequest;
import com.example.car_connect.model.dto.user.OwnerResponse;
import com.example.car_connect.model.dto.user.UserRegister;
import com.example.car_connect.model.dto.user.UserResponse;

import java.util.List;

public interface UserMapper {
    User toUser(User user, OwnerRequest request);
    User toUser(UserRegister register);
    UserResponse toResponse(User user);
    List<UserResponse> toResponses(List<User> user);
    OwnerResponse toOwnerResponse(User user);
    List<OwnerResponse> toOwnerResponses(List<User> users);
}
