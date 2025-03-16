package com.example.car_connect.service;

import com.example.car_connect.model.dto.car.CarRegisterRequest;
import com.example.car_connect.model.dto.car.CarResponse;
import com.example.car_connect.model.dto.car.CarResponseDetail;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;
import java.util.UUID;

public interface CarService {
    CarResponseDetail register(CarRegisterRequest request, UUID id);
    CarResponseDetail getDetail(UUID id);
    List<CarResponse> getRelatedCars(UUID id);
    List<CarResponse> all();
}
