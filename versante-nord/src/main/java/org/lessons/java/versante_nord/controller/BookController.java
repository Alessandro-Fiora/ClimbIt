package org.lessons.java.versante_nord.controller;

import java.util.List;

import org.lessons.java.versante_nord.model.Book;
import org.lessons.java.versante_nord.service.BookService;
import org.lessons.java.versante_nord.service.CategoryService;
import org.lessons.java.versante_nord.service.RegionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import jakarta.validation.Valid;

@Controller
@RequestMapping("/books")
public class BookController {
    
    @Autowired
    private BookService bookService;

    @Autowired
    private RegionService regionService;

    @Autowired
    private CategoryService categoryService;

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

    @GetMapping("/search")
    public String search(@RequestParam("query") String query, Model model) {
        List<Book> books = bookService.findByTitleAuthorRegionCategory(query);
        model.addAttribute("books", books);

        return "books/index";
    }

    @GetMapping("/create")
    public String create(Model model){
        Book book = new Book();
        // inserisco placeholder per comodità di testing
        book.setImmagine("https://placehold.co/456x638");
        model.addAttribute("book", book);
        model.addAttribute("regions", regionService.findAll());
        model.addAttribute("categories", categoryService.findAll());

        return "books/create-or-edit";
    }

    @PostMapping("/create")
    public String store(@Valid @ModelAttribute("book") Book formBook, BindingResult bindingResult, Model model ) {
        
        if(bindingResult.hasErrors()){
            model.addAttribute("regions", regionService.findAll());
            model.addAttribute("categories", categoryService.findAll());


            return "books/create-or-edit";
        }

        bookService.create(formBook);

        return "redirect:/books/" + formBook.getId();
    }

    @GetMapping("/edit/{id}")
    public String edit(@PathVariable Integer id, Model model) {
        model.addAttribute("edit", true);
        model.addAttribute("book", bookService.getById(id));
        model.addAttribute("regions", regionService.findAll());
        model.addAttribute("categories", categoryService.findAll());


        return "books/create-or-edit";
    }

    @PostMapping("/edit/{id}")
    public String update(@Valid @ModelAttribute("book") Book formBook, BindingResult bindingResult, Model model ) {
        if(bindingResult.hasErrors()){
            model.addAttribute("regions", regionService.findAll());
            model.addAttribute("categories", categoryService.findAll());


            return "books/create-or-edit";
        }
        bookService.update(formBook);
        
        return "redirect:/books/" + formBook.getId();
    }

    @PostMapping("/delete/{id}")
    public String delete(@PathVariable Integer id){
        
        bookService.deleteById(id);

        return "redirect:/books";
    }


}
