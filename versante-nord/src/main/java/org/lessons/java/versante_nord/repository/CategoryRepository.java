package org.lessons.java.versante_nord.repository;

import java.util.List;

import org.lessons.java.versante_nord.model.Category;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoryRepository extends JpaRepository<Category, Integer> {
    public List<Category> findByNomeContainingIgnoreCase(String nome);
}
