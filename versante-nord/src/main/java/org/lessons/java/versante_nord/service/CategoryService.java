package org.lessons.java.versante_nord.service;

import java.util.List;
import java.util.Optional;

import org.lessons.java.versante_nord.model.Category;
import org.lessons.java.versante_nord.repository.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CategoryService {

    @Autowired
    private CategoryRepository categoryRepository;

    public List<Category> findAll() {
        return categoryRepository.findAll();
    }

    public Optional<Category> findById(Integer id) {
        return categoryRepository.findById(id);
    }

    public Category getById(Integer id) {
        Optional<Category> categoryOpt = this.findById(id);
        if(categoryOpt.isEmpty()){
            return null;
        }

        return categoryOpt.get();
    }

    public Category create(Category category) {
        
        return categoryRepository.save(category);
    }

    public Category update(Category category) {
        
        return categoryRepository.save(category);
    }

    public void deleteById(Integer id) {
        categoryRepository.deleteById(id);
    }

    public void delete(Category category) {
        categoryRepository.delete(category);
    }
}
