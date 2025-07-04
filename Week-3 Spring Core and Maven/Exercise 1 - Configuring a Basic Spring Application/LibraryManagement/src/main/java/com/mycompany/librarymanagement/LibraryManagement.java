/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.librarymanagement;

import com.mycompany.librarymanagement.repository.BookRepository;
import com.mycompany.librarymanagement.service.BookService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class LibraryManagement {
    public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
        BookService bookService = (BookService) context.getBean("bookService");
        bookService.display();
        BookRepository bookRepository = (BookRepository) context.getBean("bookRepository");
        bookRepository.loadBooks();
    }
}