package com.textgeek.webserver.service;

import com.textgeek.webserver.model.Book;
import com.textgeek.webserver.repository.BookRepository;
import java.util.List;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BookService {

    @Autowired
    private BookRepository repository;

    public List<Book> getBooks(Map<String, String> allParams) {
        return repository.findAllWithParams(allParams);
    }

}
