package com.example.webdevtask.controller;

import com.example.webdevtask.entity.Book;
import com.example.webdevtask.pojo.BookPojo;
import com.example.webdevtask.service.BookService;
import com.example.webdevtask.shared.pojo.GlobalApiResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/book")
@RequiredArgsConstructor
public class BookController {

    private final BookService bookService;

    @GetMapping("/get")
    public GlobalApiResponse<Book> getData() {
        return GlobalApiResponse.
                <Book>builder()
                .data("saved")
                .statusCode(200)
                .message("Data retrieved successfully!")
                .build();
    }

    @PostMapping("/save")
    public void save(@RequestBody BookPojo bookPojo) {
        this.bookService.saveData(bookPojo);
    }

    @GetMapping("/get/{id}")
    public Optional<Book> getData(@PathVariable Integer id) {
        return bookService.findById(id);
    }

    @DeleteMapping("/delete/{id}")
    public void delete(@PathVariable Integer id) {
        this.bookService.deleteById(id);
    }
}