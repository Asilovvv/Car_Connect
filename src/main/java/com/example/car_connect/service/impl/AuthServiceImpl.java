package com.example.car_connect.service.impl;

import com.example.car_connect.config.JwtService;
import com.example.car_connect.exception.CustomException;
import com.example.car_connect.mapper.AuthMapper;
import com.example.car_connect.model.domain.User;
import com.example.car_connect.model.dto.auth.AuthLogin;
import com.example.car_connect.model.dto.auth.AuthRegister;
import com.example.car_connect.model.dto.auth.AuthResponse;
import com.example.car_connect.repository.UserRepository;
import com.example.car_connect.service.AuthService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class AuthServiceImpl implements AuthService {
    private final UserRepository userRepository;
    private final AuthMapper authMapper;
    private final JwtService jwtService;
    private final PasswordEncoder passwordEncoder;
    private final AuthenticationManager authenticationManager;

    @Override
    public AuthResponse register(AuthRegister register) {
        if (userRepository.findByEmail(register.getEmail()).isPresent()) {
            throw new CustomException("User with this email found", HttpStatus.CONFLICT);
        } else if (userRepository.findByName(register.getName()).isPresent()) {
            throw new CustomException("User with this name found", HttpStatus.CONFLICT);
        }
        register.setPassword(passwordEncoder.encode(register.getPassword()));

        User user = userRepository.save(authMapper.toUser(register));
        String token = jwtService.generateToken(user);
        return authMapper.toResponse(user.getId(), token);
    }

    @Override
    public AuthResponse login(AuthLogin login) {
        authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(
                        login.getIdentifier(),
                        login.getPassword()
                )
        );
        User user = userRepository.findByNameOrEmail(login.getIdentifier(), login.getIdentifier()).orElseThrow(() -> new CustomException("User not found", HttpStatus.NOT_FOUND));
        return authMapper.toResponse(user.getId(), jwtService.generateToken(user));
    }
}
