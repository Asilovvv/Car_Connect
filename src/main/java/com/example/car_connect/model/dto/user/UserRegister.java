package com.example.car_connect.model.dto.user;

import lombok.Data;

@Data
public class UserRegister {
    private String name;
    private String email;
    private String password;
    private String phone;
}
