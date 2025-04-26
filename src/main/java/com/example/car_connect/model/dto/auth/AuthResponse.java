package com.example.car_connect.model.dto.auth;

import lombok.Getter;
import lombok.Setter;

import java.util.UUID;

@Getter
@Setter
public class AuthResponse {
    private UUID id;
    private String token;
}
