package com.thesposito.spring_library.controller;

import com.thesposito.spring_library.model.Book;
import com.thesposito.spring_library.service.BookService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/book")
public class BookController {
    private final BookService bookService;

    public BookController(BookService bookService) {
        this.bookService = bookService;
    }

    @GetMapping()
    public List<Book> findAll() {
        return bookService.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Book> findById(@PathVariable Long id) {
        return bookService.findById(id)
                .map(b -> ResponseEntity.ok(b)) // Equivale a ResponseEntity::ok
                .orElse(ResponseEntity.notFound().build());
    }

    @GetMapping("/available")
    public List<Book> findAllAvailable() {
        return bookService.findAllAvailable();
    }

    @GetMapping
    public List<Book> findByTitle(@RequestParam String title) {
        return bookService.findByTitle(title);
    }

    @GetMapping
    public List<Book> findAfterPublicationYear(@RequestParam Integer y) {
        return bookService.findAfterPublicationYear(y);
    }

    @PostMapping
    public Book createBook(@RequestBody Book b) {
        return bookService.saveBook(b);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteById(@PathVariable Long id) {
        bookService.deleteById(id);
        return ResponseEntity.noContent().build();
    }

    @PatchMapping("/{id}/lend")
    public ResponseEntity<Void> lendBook(@PathVariable Long id) {
        boolean success = bookService.lendBookById(id);
        if (!success) return ResponseEntity.badRequest().build();

        return ResponseEntity.ok().build();
    }

    @PatchMapping("/{id}/return")
    public ResponseEntity<Void> returnBook(@PathVariable Long id){
        boolean success = bookService.returnBookById(id);
        if(!success) return ResponseEntity.badRequest().build();

        return ResponseEntity.ok().build();
    }
}
