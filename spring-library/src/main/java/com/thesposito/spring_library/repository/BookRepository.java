package com.thesposito.spring_library.repository;

import com.thesposito.spring_library.model.Book;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface BookRepository extends JpaRepository<Book, Long> {
    // O spring, pelo nome do método, já entende as condicionais e cria as Queries sozinho!!!!!

    /*
    SELECT * FROM books
    WHERE available = true
     */
    List<Book> findByAvailableTrue();

    /*
    SELECT * FROM books
    WHERE
        available = true and
        author = ?
    */
    List<Book> findByAvailableTrueAndAuthor(String author);

    /*
    SELECT * FROM books
    WHERE title LIKE %?%
     */
    List<Book> findByTitleContainingIgnoreCase(String title);

    List<Book> findByPublicationYearGreaterThan(Integer year);
}
