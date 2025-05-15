package org.lessons.java.versante_nord.repository;

import java.util.List;

import org.lessons.java.versante_nord.model.Region;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RegionRepository extends JpaRepository<Region, Integer> {
   public List<Region> findByNomeContainingIgnoreCase(String nome);
}
