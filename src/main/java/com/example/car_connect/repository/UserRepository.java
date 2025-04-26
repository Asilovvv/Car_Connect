package com.example.car_connect.repository;

import com.example.car_connect.model.domain.User;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;
import java.util.UUID;

@Repository
public interface UserRepository extends JpaRepository<User, UUID> {
    Optional<User> findByNameOrEmail(String username, String email);

    Optional<Object> findByEmail(@NotBlank @Email(message = "Incorrect email") String email);

    Optional<Object> findByName(@NotBlank String name);
}
