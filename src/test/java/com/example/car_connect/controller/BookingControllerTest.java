package com.example.car_connect.controller;

import com.example.car_connect.model.dto.booking.BookingRequest;
import com.example.car_connect.model.dto.booking.BookingResponse;
import com.example.car_connect.service.BookingService;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;

@ExtendWith(SpringExtension.class)
@WebMvcTest(BookingController.class)
class BookingControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private BookingService bookingService;

    @Autowired
    private ObjectMapper objectMapper;

    private UUID testBookingId;
    private UUID testUserId;
    private UUID testCarId;
    private BookingResponse testBookingResponse;
    private BookingRequest testBookingRequest;

    @BeforeEach
    void setUp() {
        testBookingId = UUID.randomUUID();
        testUserId = UUID.randomUUID();
        testCarId = UUID.randomUUID();

        testBookingResponse = new BookingResponse();
        testBookingResponse.setId(testBookingId);
        testBookingResponse.setStartDate(LocalDateTime.now().plusDays(1));
        testBookingResponse.setEndDate(LocalDateTime.now().plusDays(2));
        testBookingResponse.setPrice(100.0);
        testBookingResponse.setStatus("CONFIRMED");

        testBookingRequest = new BookingRequest();
        testBookingRequest.setStartDate(LocalDateTime.now().plusDays(1));
        testBookingRequest.setEndDate(LocalDateTime.now().plusDays(2));
        testBookingRequest.setPrice(100.0);
    }

    @Test
    void getAllBookings() throws Exception {
        when(bookingService.getAllBookings(anyInt(), anyInt())).thenReturn(List.of(testBookingResponse));

        mockMvc.perform(MockMvcRequestBuilders.get("/bookings"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$[0].id").value(testBookingId.toString()));
    }

    @Test
    void getBookingById() throws Exception {
        when(bookingService.getBookingById(testBookingId)).thenReturn(testBookingResponse);

        mockMvc.perform(MockMvcRequestBuilders.get("/bookings/" + testBookingId))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.id").value(testBookingId.toString()));
    }

    @Test
    void create() throws Exception {
        when(bookingService.create(eq(testUserId), eq(testCarId), any(BookingRequest.class)))
                .thenReturn(List.of(testBookingResponse));

        mockMvc.perform(MockMvcRequestBuilders.post("/bookings/" + testCarId)
                        .param("userId", testUserId.toString())
                        .contentType("application/json")
                        .content(objectMapper.writeValueAsString(testBookingRequest)))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$[0].id").value(testBookingId.toString()));
    }
}