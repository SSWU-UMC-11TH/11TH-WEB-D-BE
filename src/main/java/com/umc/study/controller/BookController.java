// src/main/java/.../controller/BookController.java

package com.umc.study.controller;

import com.umc.study.dto.BookResponse;
import com.umc.study.service.BookService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

import org.springframework.http.HttpStatus;
import jakarta.validation.Valid;
import com.umc.study.dto.BookCreateRequest;

@RestController
@RequestMapping("/books")
@RequiredArgsConstructor
public class BookController {
    private final BookService bookService;

    @GetMapping
    public List<BookResponse> getBooks() {
        return bookService.getBooks();
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public BookResponse createBook(@Valid @RequestBody BookCreateRequest request) {
        return bookService.createBook(request);
    }
}