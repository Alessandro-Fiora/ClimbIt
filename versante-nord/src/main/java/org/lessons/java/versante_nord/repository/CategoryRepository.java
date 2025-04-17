package org.lessons.java.versante_nord.repository;

import org.lessons.java.versante_nord.model.Category;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoryRepository extends JpaRepository<Category, Integer> {
    // Non sono necessarie query personalizzate per ora
    // Se necessario, aggiungere metodi qui in seguito
}
