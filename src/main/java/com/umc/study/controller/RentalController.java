package com.umc.study.controller;

import com.umc.study.service.RentalService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
@RequestMapping("/rentals")
@RequiredArgsConstructor
public class RentalController {

    private final RentalService rentalService;

    public record RentalRequest(Long userId, Long bookId) {}

    @PostMapping
    public ResponseEntity<Map<String, Object>> createRental(@RequestBody RentalRequest request) {
        rentalService.createRental(request.userId(), request.bookId());
        return ResponseEntity.status(HttpStatus.CREATED)
                .body(Map.of("message", "대여 기록이 생성되었습니다."));
    }
}