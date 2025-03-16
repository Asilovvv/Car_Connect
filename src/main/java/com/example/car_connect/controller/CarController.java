package com.example.car_connect.controller;

import com.example.car_connect.model.dto.car.CarRegisterRequest;
import com.example.car_connect.model.dto.car.CarResponse;
import com.example.car_connect.model.dto.car.CarResponseDetail;
import com.example.car_connect.service.CarService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;
import java.util.UUID;

@RestController
@AllArgsConstructor
@RequestMapping("/cars")
public class CarController {
    private CarService carService;

    @PostMapping("/register")
    public CarResponseDetail register(
            @RequestBody CarRegisterRequest request,
            @RequestParam UUID id
    ) {
        return carService.register(request, id);
    }

    @GetMapping("/{id}")
    public CarResponseDetail getDetail(@PathVariable UUID id) {
        return carService.getDetail(id);
    }
    @GetMapping
    public List<CarResponse> all() {
        return carService.all();
    }

    @GetMapping("/related_cars/{id}")
    public List<CarResponse> getRelatedCars(@PathVariable UUID id) {
        return carService.getRelatedCars(id);
    }
}
