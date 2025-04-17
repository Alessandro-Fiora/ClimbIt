package org.lessons.java.versante_nord.service;

import java.util.List;
import java.util.Optional;

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

    public Optional<Book> findById(Integer id) {
        return bookRepository.findById(id);
    }

    public Book getById(Integer id) {
        Optional<Book> bookOpt = this.findById(id);
        if(bookOpt.isEmpty()){
            return null;
        }

        return bookOpt.get();
    }

    public Book create(Book book) {
        
        return bookRepository.save(book);
    }

    public Book update(Book book) {
        
        return bookRepository.save(book);
    }

    public void deleteById(Integer id) {
        bookRepository.deleteById(id);
    }

    public void delete(Book book) {
        bookRepository.delete(book);
    }
}
