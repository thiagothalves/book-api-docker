package com.example.book.service;

import com.example.book.core.Book;
import com.example.book.repository.BookRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class BookService {

    private final BookRepository bookRepository;


    public BookService(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    public Book create(Book book) {
        return bookRepository.save(book);
    }

    public List<Book> findAll() {
        return bookRepository.findAll();
    }

    public Book findOne(Long id) {
        Optional<Book> one = bookRepository.findById(id);
        return one.isPresent() ? one.get() : null;
    }

    public void remove(Long id) {
        bookRepository.deleteById(id);
    }

}
