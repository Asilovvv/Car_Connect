package com.example.car_connect.service;

import com.example.car_connect.model.dto.booking.BookingRequest;
import com.example.car_connect.model.dto.booking.BookingResponse;

import java.util.List;
import java.util.UUID;

public interface BookingService {
    List<BookingResponse> getAllBookings(int page, int size);
    List<BookingResponse> getAllBookingsByStatus(String status, int page, int size);
    List<BookingResponse> getAllTenantsBooking(UUID id, int page, int size);
    BookingResponse getBookingById(UUID id);
    List<BookingResponse> create(UUID id, UUID carId, BookingRequest request);

}
