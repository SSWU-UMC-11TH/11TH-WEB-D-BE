package com.umc.study.service;

import com.umc.study.repository.RentalRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class RentalService {

    private final RentalRepository rentalRepository;

    public void createRental(Long userId, Long bookId) {
        if (userId == null || bookId == null) {
            throw new IllegalArgumentException("userId와 bookId는 필수입니다.");
        }
        rentalRepository.save(userId, bookId);
    }
}