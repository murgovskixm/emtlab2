package com.example.lab.service.impl;

import com.example.lab.model.Author;
import com.example.lab.model.Country;
import com.example.lab.repository.AuthorRepository;
import com.example.lab.service.AuthorService;
import com.example.lab.service.CountryService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AuthorServiceImpl implements AuthorService {

    private final AuthorRepository authorRepository;
    private final CountryService countryService;

    public AuthorServiceImpl(AuthorRepository authorRepository, CountryService countryService) {
        this.authorRepository = authorRepository;
        this.countryService = countryService;
    }

    @Override
    public List<Author> findAll() {
        return this.authorRepository.findAll();
    }

    @Override
    public Optional<Author> findById(Long id) {
        return this.authorRepository.findById(id);
    }

    @Override
    public Optional<Author> add(String name, String surname, Long cId) {
        Country country=this.countryService.findById(cId).orElse(null);
        return Optional.of(this.authorRepository.save(new Author(name,surname,country)));

    }
}
