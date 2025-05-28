package org.lessons.java.versante_nord.controller;

import java.util.List;
import java.util.Optional;

import org.lessons.java.versante_nord.model.Book;
import org.lessons.java.versante_nord.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;


@RestController
@RequestMapping("/api/books")
public class BookRestController {
    
    @Autowired
    private BookService bookService;

    @GetMapping
    @CrossOrigin(origins = "http://localhost:5173")
    public ResponseEntity<List<Book>> index() {
        return new ResponseEntity<List<Book>>(bookService.findAll(), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    @CrossOrigin(origins = "http://localhost:5173")
    public ResponseEntity<Book> show(@PathVariable Integer id){
        Optional <Book> bookOpt = bookService.findById(id);

        if (bookOpt.isEmpty()) {
            return new ResponseEntity<Book>(HttpStatus.NOT_FOUND);
        }

        return new ResponseEntity<Book>(bookOpt.get(), HttpStatus.OK);
    }

    @PostMapping
    @CrossOrigin(origins = "http://localhost:5173")
    public ResponseEntity<Book> store(@RequestBody Book book){
        return new ResponseEntity<Book>(bookService.create(book), HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    @CrossOrigin(origins = "http://localhost:5173")
    public ResponseEntity<Book> update(@PathVariable Integer id, @RequestBody Book book){
        if (bookService.findById(id).isEmpty()) {
            return new ResponseEntity<Book>(HttpStatus.NOT_FOUND);
        }
        book.setId(id);
        return new ResponseEntity<Book>(bookService.update(book), HttpStatus.OK);

    }

    @DeleteMapping("/{id}")
    @CrossOrigin(origins = "http://localhost:5173")
    public ResponseEntity<Book> destroy(@PathVariable Integer id){
        if (bookService.findById(id).isEmpty()) {
            return new ResponseEntity<Book>(HttpStatus.NOT_FOUND);
        }
        bookService.deleteById(id);
        return new ResponseEntity<Book>(HttpStatus.NO_CONTENT);
    }
    
}
