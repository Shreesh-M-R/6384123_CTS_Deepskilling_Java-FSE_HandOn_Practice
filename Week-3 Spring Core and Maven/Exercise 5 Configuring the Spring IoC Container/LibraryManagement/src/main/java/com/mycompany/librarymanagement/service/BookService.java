package com.mycompany.librarymanagement.service;

import com.mycompany.librarymanagement.repository.BookRepository; 
public class BookService {
    private BookRepository bookRepository;

    public void setBookRepository(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    public void displayBooks() {
        System.out.println("BookService: Displaying books...");
        bookRepository.loadBooks();
    }
}
