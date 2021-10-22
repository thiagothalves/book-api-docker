package com.example.book.controller;

import com.example.book.core.Book;
import com.example.book.service.BookService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1/book")
public class BookController {

    private final BookService bookService;

    public BookController(BookService bookService) {
        this.bookService = bookService;
    }


    @GetMapping
    public ResponseEntity<List<Book>> findAll() {
        List<Book> books = bookService.findAll();

        return books.isEmpty() ?
                new ResponseEntity<>(HttpStatus.NO_CONTENT) :
                new ResponseEntity<>(books, HttpStatus.OK);

    }


    @GetMapping(path = "{id}")
    public ResponseEntity<Book> findOne(@PathVariable("id") Long id) {
        Book one = bookService.findOne(id);
        return one == null ?
                new ResponseEntity<>(HttpStatus.NOT_FOUND) :
                ResponseEntity.ok().body(one);
    }


    @PostMapping
    public ResponseEntity<Book> create(@RequestBody Book book) {
        return new ResponseEntity<>(bookService.create(book), HttpStatus.CREATED);
    }


    @DeleteMapping("{id}")
    public ResponseEntity<?> remove(@PathVariable(value = "id") Long id) {
        bookService.remove(id);
        return ResponseEntity.ok().build();
    }

}
