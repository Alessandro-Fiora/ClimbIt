package org.lessons.java.versante_nord.repository;

import java.util.List;

import org.lessons.java.versante_nord.model.Book;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BookRepository extends JpaRepository<Book, Integer> {

    public List<Book> findByTitoloContainingIgnoreCaseOrAutoreContainingIgnoreCase(String title, String autore);
    
}
