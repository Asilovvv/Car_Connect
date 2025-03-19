package com.example.car_connect.controller;

import com.example.car_connect.model.dto.user.UserRegister;
import com.example.car_connect.model.dto.user.UserResponse;
import com.example.car_connect.service.MyUserService;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.http.MediaType;

import java.util.Collections;
import java.util.List;
import java.util.UUID;

import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@WebMvcTest(UserController.class)
@ExtendWith(MockitoExtension.class)
class UserControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private MyUserService service;

    @Autowired
    private ObjectMapper objectMapper;

    private UserRegister userRegister;
    private UserResponse userResponse;
    private UUID userId;

    @BeforeEach
    void setUp() {
        userId = UUID.randomUUID();
        userRegister = new UserRegister();
        userRegister.setName("John Doe");
        userRegister.setEmail("john.doe@example.com");
        userRegister.setPassword("password");
        userRegister.setPhone("123456789");

        userResponse = new UserResponse();
        userResponse.setId(userId);
        userResponse.setName("John Doe");
        userResponse.setEmail("john.doe@example.com");
        userResponse.setPhone("123456789");
    }

    @Test
    void register() throws Exception {
        when(service.register(any(UserRegister.class))).thenReturn(userResponse);

        mockMvc.perform(MockMvcRequestBuilders.post("/users/register")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(userRegister)))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.id").value(userResponse.getId().toString()))
                .andExpect(jsonPath("$.name").value(userResponse.getName()))
                .andExpect(jsonPath("$.email").value(userResponse.getEmail()))
                .andExpect(jsonPath("$.phone").value(userResponse.getPhone()));
    }


    @Test
    void all() throws Exception {
        List<UserResponse> users = Collections.singletonList(userResponse);
        when(service.all()).thenReturn(users);

        mockMvc.perform(MockMvcRequestBuilders.get("/users/all"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$[0].id").value(userResponse.getId().toString()))
                .andExpect(jsonPath("$[0].name").value(userResponse.getName()))
                .andExpect(jsonPath("$[0].email").value(userResponse.getEmail()))
                .andExpect(jsonPath("$[0].phone").value(userResponse.getPhone()));
    }
}