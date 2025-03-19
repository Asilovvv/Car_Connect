package com.example.car_connect.controller;

import com.example.car_connect.model.dto.review.ReviewResponse;
import com.example.car_connect.service.ReviewService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import java.util.List;
import java.util.UUID;

import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

class ReviewControllerTest {

    private MockMvc mockMvc;

    @Mock
    private ReviewService reviewService;

    @InjectMocks
    private ReviewController reviewController;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
        mockMvc = MockMvcBuilders.standaloneSetup(reviewController).build();
    }

    @Test
    void getAllReviews() throws Exception {
        UUID carId = UUID.randomUUID();
        when(reviewService.getAllReviews(eq(carId), anyInt(), anyInt())).thenReturn(List.of());

        mockMvc.perform(get("/reviews/{carId}", carId)
                        .param("page", "0")
                        .param("size", "10")
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk());
    }

    @Test
    void makeReview() throws Exception {
        UUID userId = UUID.randomUUID();
        UUID carId = UUID.randomUUID();
        when(reviewService.makeReview(eq(userId), eq(carId), any(), anyInt())).thenReturn(List.of(new ReviewResponse()));

        mockMvc.perform(post("/reviews/make/{carId}", carId)
                        .param("userId", userId.toString())
                        .param("comment", "Great car!")
                        .param("rating", "5")
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk());

        verify(reviewService, times(1)).makeReview(eq(userId), eq(carId), eq("Great car!"), eq(5));
    }
}
