package com.example.car_connect.model.dto.user;

import com.example.car_connect.model.dto.booking.BookingResponse;
import lombok.Data;

import java.util.List;
import java.util.UUID;

@Data
public class UserResponse {
    private UUID id;
    private String name;
    private String email;
    private String phone;
}
