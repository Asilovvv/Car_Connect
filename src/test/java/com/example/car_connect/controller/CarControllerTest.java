package com.example.car_connect.controller;

import com.example.car_connect.model.dto.car.CarRegisterRequest;
import com.example.car_connect.model.dto.car.CarResponse;
import com.example.car_connect.model.dto.car.CarResponseDetail;
import com.example.car_connect.service.CarService;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import java.util.Collections;
import java.util.List;
import java.util.UUID;

import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

class CarControllerTest {

    private MockMvc mockMvc;

    @Mock
    private CarService carService;

    @InjectMocks
    private CarController carController;

    private ObjectMapper objectMapper = new ObjectMapper();

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
        mockMvc = MockMvcBuilders.standaloneSetup(carController).build();
    }

    @Test
    void register() throws Exception {
        UUID userId = UUID.randomUUID();
        CarRegisterRequest request = new CarRegisterRequest();
        request.setMake("Toyota");
        CarResponseDetail response = new CarResponseDetail();
        response.setId(UUID.randomUUID());

        when(carService.register(any(CarRegisterRequest.class), eq(userId))).thenReturn(response);

        mockMvc.perform(post("/cars/register")
                        .contentType(MediaType.APPLICATION_JSON)
                        .param("id", userId.toString())
                        .content(objectMapper.writeValueAsString(request)))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.id").exists());
    }

    @Test
    void getDetail() throws Exception {
        UUID carId = UUID.randomUUID();
        CarResponseDetail response = new CarResponseDetail();
        response.setId(carId);

        when(carService.getDetail(carId)).thenReturn(response);

        mockMvc.perform(get("/cars/{id}", carId))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.id").value(carId.toString()));
    }

    @Test
    void all() throws Exception {
        List<CarResponse> cars = Collections.singletonList(new CarResponse());

        when(carService.all()).thenReturn(cars);

        mockMvc.perform(get("/cars"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.length()").value(1));
    }

    @Test
    void getRelatedCars() throws Exception {
        UUID carId = UUID.randomUUID();
        List<CarResponse> cars = Collections.singletonList(new CarResponse());

        when(carService.getRelatedCars(carId)).thenReturn(cars);

        mockMvc.perform(get("/cars/related_cars/{id}", carId))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.length()").value(1));
    }
}
