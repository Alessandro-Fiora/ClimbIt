package org.lessons.java.versante_nord.service;

import java.util.List;

import org.lessons.java.versante_nord.model.Book;
import org.lessons.java.versante_nord.repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BookService {
    
    @Autowired
    private BookRepository bookRepository;

    public List<Book> findAll() {
        return bookRepository.findAll();
    }
}
