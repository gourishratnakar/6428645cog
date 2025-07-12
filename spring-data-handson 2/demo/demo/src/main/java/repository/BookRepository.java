package com.example.demo.repository;

import com.example.demo.entity.Book;
import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDate;
import java.util.List;

public interface BookRepository extends JpaRepository<Book, Long> {
    List<Book> findByTitleContaining(String keyword);
    List<Book> findByAuthorStartingWith(String prefix);
    List<Book> findByPriceGreaterThan(double price);
    List<Book> findByPublishedDateBetween(LocalDate start, LocalDate end);
    List<Book> findTop3ByOrderByPublishedDateDesc();
}
