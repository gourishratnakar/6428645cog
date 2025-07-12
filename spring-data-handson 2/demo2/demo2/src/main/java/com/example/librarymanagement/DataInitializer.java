package com.example.librarymanagement;

import com.example.librarymanagement.entity.Author;
import com.example.librarymanagement.entity.Book;
import com.example.librarymanagement.entity.Student;
import com.example.librarymanagement.repository.AuthorRepository;
import com.example.librarymanagement.repository.BookRepository;
import com.example.librarymanagement.repository.StudentRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class DataInitializer {

    @Bean
    CommandLineRunner initData(
            AuthorRepository authorRepository,
            BookRepository bookRepository,
            StudentRepository studentRepository) {

        return args -> {
            // Create sample authors
            Author author1 = new Author("J.K. Rowling");
            Author author2 = new Author("George R.R. Martin");

            authorRepository.save(author1);
            authorRepository.save(author2);

            // Create books and assign authors
            Book book1 = new Book("Harry Potter", author1);
            Book book2 = new Book("Game of Thrones", author2);

            bookRepository.save(book1);
            bookRepository.save(book2);

            // Create students
            Student student1 = new Student("Alice");
            Student student2 = new Student("Bob");

            studentRepository.save(student1);
            studentRepository.save(student2);

            System.out.println("✅ Sample data inserted.");
        };
    }
}
