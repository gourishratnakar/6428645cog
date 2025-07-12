package com.example.demo;

import com.example.demo.entity.Book;
import com.example.demo.repository.BookRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.time.LocalDate;

@SpringBootApplication
public class DemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);
	}

	@Bean
	public CommandLineRunner demo(BookRepository bookRepo) {
		return args -> {
			bookRepo.save(new Book(null, "Spring Boot Guide", "Sam", 499, LocalDate.of(2024, 3, 1)));
			bookRepo.save(new Book(null, "Java in Depth", "Sara", 799, LocalDate.of(2023, 7, 15)));
			bookRepo.save(new Book(null, "JPA Mastery", "John", 599, LocalDate.of(2022, 10, 30)));

			System.out.println("🔍 Search by title: " + bookRepo.findByTitleContaining("Java"));
			System.out.println("🔍 Author starting with 'Sa': " + bookRepo.findByAuthorStartingWith("Sa"));
			System.out.println("💰 Books > ₹500: " + bookRepo.findByPriceGreaterThan(500));
			System.out.println("📅 Published 2023-2024: " +
					bookRepo.findByPublishedDateBetween(LocalDate.of(2023, 1, 1), LocalDate.of(2024, 12, 31)));
			System.out.println("🔥 Top 3 latest books: " + bookRepo.findTop3ByOrderByPublishedDateDesc());
		};
	}
}

