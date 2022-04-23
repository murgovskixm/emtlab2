package com.example.lab.service;

import com.example.lab.model.Author;
import com.example.lab.model.Book;
import com.example.lab.model.Category;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;
import java.util.Optional;

public interface BooksService {

    Optional<Book> create(String name, Category category, Long aId, Integer availableCopies);
    Optional<Book> edit(Long id, String name, Category category, Long aId, Integer availableCopies);
    void delete(Long id);
    List<Book> listBooks();
    Optional<Book> findById(Long id);
    Page<Book> findAllWithPagination(Pageable pageable);
}
