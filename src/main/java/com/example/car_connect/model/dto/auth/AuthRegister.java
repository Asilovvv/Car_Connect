package com.example.car_connect.model.dto.auth;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class AuthRegister {
    @NotBlank
    private String name;
    @NotBlank
    @Email(message = "Incorrect email")
    private String email;
    private String password;
    private String confirmPassword;
    private String role;
}
