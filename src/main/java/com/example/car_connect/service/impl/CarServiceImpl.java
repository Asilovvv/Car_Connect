package com.example.car_connect.service.impl;

import com.example.car_connect.exception.CustomException;
import com.example.car_connect.mapper.CarMapper;
import com.example.car_connect.model.domain.Car;
import com.example.car_connect.model.domain.User;
import com.example.car_connect.model.dto.car.CarRegisterRequest;
import com.example.car_connect.model.dto.car.CarResponse;
import com.example.car_connect.model.dto.car.CarResponseDetail;
import com.example.car_connect.repository.CarRepository;
import com.example.car_connect.repository.UserRepository;
import com.example.car_connect.service.CarService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
@AllArgsConstructor
public class CarServiceImpl implements CarService {
    private final CarRepository carRepository;
    private final UserRepository userRepository;
    private final CarMapper carMapper;

    @Override
    public CarResponseDetail register(CarRegisterRequest request, UUID id) {
        User owner = userRepository.findById(id).orElseThrow(() -> new CustomException("User not found", HttpStatus.NOT_FOUND));
        Car car = carRepository.save(carMapper.toCar(request, owner));
        return carMapper.toResponseDetail(car);
    }

    @Override
    public CarResponseDetail getDetail(UUID id) {
        return carMapper.toResponseDetail(carRepository.findById(id).orElseThrow(() -> new RuntimeException("Car not found")));
    }

    @Override
    public List<CarResponse> getRelatedCars(UUID id) {
        Car car = carRepository.findById(id).orElseThrow(() -> new CustomException("Car not found", HttpStatus.NOT_FOUND));
        return carMapper.toCarResponseList(carRepository.findAllRelatedCars(car.getMake(), car.getModel(), car.getColor(), car.getYear(), car.getPrice(), car.getLocation(), car.getRating()));
    }

    @Override
    public List<CarResponse> all() {
        return carMapper.toCarResponseList(carRepository.findAll());
    }
}
