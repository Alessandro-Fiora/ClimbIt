package org.lessons.java.versante_nord.repository;

import org.lessons.java.versante_nord.model.Book;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BookRepository extends JpaRepository<Book, Integer> {
    // Non sono necessari metodi aggiuntivi per ora
    // JpaRepository fornisce già i metodi CRUD di base
    
}
