package com.example.lab.web;

import com.example.lab.model.Country;
import com.example.lab.service.CountryService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/country")
public class CountryRestController {
    private final CountryService countryService;

    public CountryRestController(CountryService countryService) {
        this.countryService = countryService;
    }

    @GetMapping
    public List<Country> findAll(){
        return this.countryService.findAll();
    }

    @PostMapping("/add")
    public ResponseEntity<Country> save(@RequestParam String name, @RequestParam String continent) {
        return this.countryService.add(name,continent)
                .map(country -> ResponseEntity.ok().body(country))
                .orElseGet(() -> ResponseEntity.badRequest().build());
    }


}
