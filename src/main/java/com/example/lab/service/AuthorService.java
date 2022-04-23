package com.example.lab.service;

import com.example.lab.model.Author;

import java.util.List;
import java.util.Optional;

public interface AuthorService {
    List<Author> findAll();
    Optional<Author> findById(Long id);
    Optional<Author> add(String name,String surname,Long cId);
}
