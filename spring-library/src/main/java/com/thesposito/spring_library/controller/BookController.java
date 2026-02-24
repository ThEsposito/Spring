package com.thesposito.spring_library.controller;

import com.thesposito.spring_library.model.Book;
import com.thesposito.spring_library.service.BookService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/book")
public class BookController {
    private final BookService bookService;

    public BookController(BookService bookService) {
        this.bookService = bookService;
    }

    @GetMapping()
    public List<Book> findAll(){
        return bookService.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Book> findById(@PathVariable Long id){
        return bookService.findById(id)
                .map(b -> ResponseEntity.ok(b)) // Equivale a ResponseEntity::ok
                .orElse(ResponseEntity.notFound().build());
    }
}
