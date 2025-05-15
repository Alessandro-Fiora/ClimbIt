package org.lessons.java.versante_nord.controller;

import java.util.List;

import org.lessons.java.versante_nord.model.Category;
import org.lessons.java.versante_nord.service.CategoryService;
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
@RequestMapping("/categories")
public class CategoryController {

    @Autowired
    private CategoryService categoryService;

    @GetMapping
    public String index(Model model) {
        List<Category> categories = categoryService.findAll();
        model.addAttribute("categories", categories);
        return "categories/index";
    }

    @GetMapping("/{id}")
    public String show(@PathVariable Integer id, Model model) {
        Category category = categoryService.getById(id);
        model.addAttribute("category", category);
        return "categories/show";
    }

    @GetMapping("/search")
    public String search(@RequestParam("query") String query, Model model) {
        List<Category> categories = categoryService.findByName(query);
        model.addAttribute("categories", categories);
        return "categories/index";
    }

    @GetMapping("/create")
    public String create(Model model) {
        Category category = new Category();
        model.addAttribute("category", category);
        return "categories/create-or-edit";
    }

    @PostMapping("/create")
    public String store(@Valid @ModelAttribute("category") Category formCategory, BindingResult bindingResult, Model model) {
        if (bindingResult.hasErrors()) {
            return "categories/create-or-edit";
        }
        categoryService.create(formCategory);
        return "redirect:/categories";
    }

    @GetMapping("/edit/{id}")
    public String edit(@PathVariable Integer id, Model model) {
        model.addAttribute("edit", true);
        model.addAttribute("category", categoryService.getById(id));
        return "categories/create-or-edit";
    }

    @PostMapping("/edit/{id}")
    public String update(@Valid @ModelAttribute("category") Category formCategory, BindingResult bindingResult, Model model) {
        if (bindingResult.hasErrors()) {
            return "categories/create-or-edit";
        }
        categoryService.update(formCategory);
        return "redirect:/categories";
    }

    @PostMapping("/delete/{id}")
    public String delete(@PathVariable Integer id) {
        categoryService.deleteById(id);
        return "redirect:/categories";
    }
}
