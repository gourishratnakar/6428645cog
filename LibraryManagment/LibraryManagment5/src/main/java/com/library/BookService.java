package com.library;

public class BookService {
    private BookRepository bookRepository;
    private String librarianName;

    // Constructor for constructor injection
    public BookService(String librarianName) {
        this.librarianName = librarianName;
    }

    // Setter for setter injection
    public void setBookRepository(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    public void issueBook() {
        System.out.println("Librarian: " + librarianName + " is issuing a book.");
        bookRepository.getBook();
    }
}
