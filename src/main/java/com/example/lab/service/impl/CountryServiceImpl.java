package com.example.lab.service.impl;

import com.example.lab.model.Country;
import com.example.lab.repository.CountryRepository;
import com.example.lab.service.CountryService;
import org.springframework.stereotype.Service;

import javax.swing.text.html.Option;
import java.util.List;
import java.util.Optional;

@Service
public class CountryServiceImpl implements CountryService {

    private final CountryRepository countryRepository;

    public CountryServiceImpl(CountryRepository countryRepository) {
        this.countryRepository = countryRepository;
    }

    @Override
    public List<Country> findAll() {
        return this.countryRepository.findAll();
    }

    @Override
    public Optional<Country> findById(Long id) {
        return this.countryRepository.findById(id);
    }

    @Override
    public Optional<Country> add(String name, String continent) {
        return Optional.of(this.countryRepository.save(new Country(name,continent)));
    }
}
