package com.mycompany.librarymanagement.repository;

import com.mycompany.librarymanagement.model.Book;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BookRepository extends JpaRepository<Book, Long> {
}
