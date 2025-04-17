package org.lessons.java.versante_nord.controller;

import java.util.List;

import org.lessons.java.versante_nord.model.Book;
import org.lessons.java.versante_nord.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/books")
public class BookController {
    
    @Autowired
    private BookService bookService;

    @GetMapping
    public String index(Model model) {

        List<Book> books = bookService.findAll();
        model.addAttribute("books", books);
        
        return "books/index";
    }

    @GetMapping("/{id}")
    public String show(@PathVariable Integer id, Model model) {
        Book book = bookService.getById(id);
        model.addAttribute("book", book);
        
        return "books/show";
    }
}
