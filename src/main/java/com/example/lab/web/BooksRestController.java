package com.example.lab.web;

import com.example.lab.model.Author;
import com.example.lab.model.Book;
import com.example.lab.model.Category;
import com.example.lab.service.BooksService;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:3000")
@RequestMapping(value = "/api/books")
public class BooksRestController {
    private final BooksService booksService;

    public BooksRestController(BooksService booksService) {
        this.booksService = booksService;
    }

    @GetMapping
    public List<Book> listBooks(){
        return this.booksService.listBooks();
    }

    @GetMapping("/pagination")
    public List<Book> listBooksWithPagination(Pageable pageable){
        return this.booksService.findAllWithPagination(pageable).getContent();
    }

    @PostMapping("/add")
    public ResponseEntity<Book> create(@RequestParam String name,
                                       @RequestParam Category category,
                                       @RequestParam Long aId,
                                       @RequestParam Integer availableCopies){
        return this.booksService.create(name,category,aId,availableCopies)
                .map(book -> ResponseEntity.ok().body(book))
                .orElseGet(()->ResponseEntity.badRequest().build());
    }

    @PutMapping("/edit/{id}")
    public ResponseEntity<Book> edit(@RequestParam Long id, @RequestParam String name,
                                     @RequestParam Category category,
                                     @RequestParam Long aId,
                                     @RequestParam Integer availableCopies){
        return this.booksService.edit(id,name,category,aId,availableCopies)
                .map(book -> ResponseEntity.ok().body(book))
                .orElseGet(()->ResponseEntity.badRequest().build());
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity deleteById(@PathVariable Long id){
        this.booksService.delete(id);
        if (this.booksService.findById(id).isEmpty())
            return ResponseEntity.ok().build();
        return ResponseEntity.badRequest().build();
    }

}
