package com.example.lab.service.impl;

import com.example.lab.model.Author;
import com.example.lab.model.Book;
import com.example.lab.model.Category;
import com.example.lab.repository.BooksRepository;
import com.example.lab.service.AuthorService;
import com.example.lab.service.BooksService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class BooksServiceImpl implements BooksService {

    private final BooksRepository booksRepository;
    private final AuthorService authorService;

    public BooksServiceImpl(BooksRepository booksRepository, AuthorService authorService) {
        this.booksRepository = booksRepository;
        this.authorService = authorService;
    }

    @Override
    public Optional<Book> create(String name, Category category, Long aId, Integer availableCopies) {
        if (name==null || name.isEmpty()) {
            throw new IllegalArgumentException();
        }
        Author author=this.authorService.findById(aId).orElse(null);
        Book b = new Book(name,category,author,availableCopies);
        return Optional.of(this.booksRepository.save(b));
    }

    @Override
    public Optional<Book> edit(Long id, String name, Category category, Long aId, Integer availableCopies) {
        if (name==null || name.isEmpty() || id==null) {
            throw new IllegalArgumentException();
        }
        Author author=this.authorService.findById(aId).orElse(null);
        Book b = new Book(name,category,author,availableCopies);
        return Optional.of(booksRepository.save(b));
    }

    @Override
    public void delete(Long id) {
        if (id==null)
            throw new IllegalArgumentException();
        booksRepository.deleteById(id);
    }

    @Override
    public List<Book> listBooks() {
        return this.booksRepository.findAll();
    }

    @Override
    public Optional<Book> findById(Long id) {
        return this.booksRepository.findById(id);
    }

    @Override
    public Page<Book> findAllWithPagination(Pageable pageable) {
        return this.booksRepository.findAll(pageable);
    }
}
