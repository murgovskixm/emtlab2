package com.example.lab.web;

import com.example.lab.model.Author;
import com.example.lab.model.Country;
import com.example.lab.service.AuthorService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/author")
public class AuthorRestController {

    private final AuthorService authorService;

    public AuthorRestController(AuthorService authorService) {
        this.authorService = authorService;
    }

    @GetMapping
    public List<Author> findAll(){
        return this.authorService.findAll();
    }

    @PostMapping("/add")
    public ResponseEntity<Author> save(@RequestParam String name, @RequestParam String surname,@RequestParam Long cId) {
        return this.authorService.add(name,surname,cId)
                .map(author -> ResponseEntity.ok().body(author))
                .orElseGet(() -> ResponseEntity.badRequest().build());
    }
}
