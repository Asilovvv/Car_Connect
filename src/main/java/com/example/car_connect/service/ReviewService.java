package com.example.car_connect.service;

import com.example.car_connect.model.dto.review.ReviewResponse;

import java.util.List;
import java.util.UUID;

public interface ReviewService {
    List<ReviewResponse> getAllReviews(UUID carId, int page, int size);
    List<ReviewResponse> makeReview(UUID userId, UUID carId, String comment, int rating);
}
