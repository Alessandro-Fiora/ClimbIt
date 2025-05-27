package org.lessons.java.versante_nord.controller;

import java.util.List;

import org.lessons.java.versante_nord.model.Book;
import org.lessons.java.versante_nord.model.Category;
import org.lessons.java.versante_nord.service.BookService;
import org.lessons.java.versante_nord.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/categories")
public class CategoryRestController {
    
    @Autowired
    private CategoryService categoryService;

    @GetMapping
    @CrossOrigin(origins = "http://localhost:5173")
    public ResponseEntity<List<Category>> index() {
        return new ResponseEntity<List<Category>>(categoryService.findAll(), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    @CrossOrigin(origins = "http://localhost:5173")
    public ResponseEntity<Category> show(@PathVariable Integer id) {
        Category category = categoryService.findById(id).orElse(null);
        if (category == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        // I libri saranno serializzati automaticamente se il mapping è corretto nella entity Category
        return new ResponseEntity<>(category, HttpStatus.OK);
    }
}
