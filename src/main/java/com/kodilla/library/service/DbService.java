package com.kodilla.library.service;

import com.kodilla.library.controller.BookNotFoundException;
import com.kodilla.library.domain.Book;
import com.kodilla.library.repository.BookRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class DbService {
    @Autowired
    private final BookRepository repository;

    public List<Book> getAllBooks(){return  repository.findAll();}
    public Book saveBook(final  Book book){
        return repository.save(book);
    }
    public Book getBookById(final Long id) throws BookNotFoundException {
        return repository.findById(id).orElseThrow(BookNotFoundException::new);
    }
}
