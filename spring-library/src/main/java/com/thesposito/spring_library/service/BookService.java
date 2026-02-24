package com.thesposito.spring_library.service;

import com.thesposito.spring_library.model.Book;
import com.thesposito.spring_library.repository.BookRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class BookService {
    private final BookRepository bookRepository;

    public BookService(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    public Book registerBook(Book b){
        b.setAvailable(true);
        return bookRepository.save(b);
    }

    public List<Book> findAll(){
        return bookRepository.findAll();
    }

    public List<Book> findAllAvailable() {
        return bookRepository.findByAvailableTrue();
    }

    public List<Book> findAvailableFromAuthor(String author){
        return bookRepository.findByAvailableTrueAndAuthor(author);
    }

    public List<Book> findByTitle(String title){
        return bookRepository.findByTitleContainingIgnoreCase(title);
    }
    public List<Book> findAfterPublicationYear(Integer year){
        return bookRepository.findByPublicationYearGreaterThan(year);
    }

    public Optional<Book> findById(Long id){
        return bookRepository.findById(id);
    }


    public void deleteById(Long id){
        bookRepository.deleteById(id);
    }

    public boolean lendBookById(Long id){
        Optional<Book> bookOptional = bookRepository.findById(id);
        if(bookOptional.isEmpty()) return false;
        Book b = bookOptional.get();
        if(!b.getAvailable()) return false;

        b.setAvailable(false);
        bookRepository.save(b);
        return true;
    }

    public boolean returnBookById(Long id){
        Book b = bookRepository.findById(id).orElse(null);
        if(b == null || b.getAvailable()) return true;

        b.setAvailable(true);
        bookRepository.save(b);
        return true;
    }
}
