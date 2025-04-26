package com.example.car_connect.model.dto.auth;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class AuthLogin {
    @NotBlank
    @Email(message = "")
    private String identifier;
    @NotBlank
    private String password;
}
