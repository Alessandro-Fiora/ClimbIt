package org.lessons.java.versante_nord.repository;

import org.lessons.java.versante_nord.model.Region;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RegionRepository extends JpaRepository<Region, Integer> {
    // Non sono necessari metodi aggiuntivi per ora
    // JpaRepository fornisce già i metodi CRUD di base
}
