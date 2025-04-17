package org.lessons.java.versante_nord.service;

import java.util.List;
import java.util.Optional;

import org.lessons.java.versante_nord.model.Region;
import org.lessons.java.versante_nord.repository.RegionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RegionService {
    
     @Autowired
    private RegionRepository regionRepository;

    public List<Region> findAll() {
        return regionRepository.findAll();
    }

    public Optional<Region> findById(Integer id) {
        return regionRepository.findById(id);
    }

    public Region getById(Integer id) {
        Optional<Region> regionOpt = this.findById(id);
        if(regionOpt.isEmpty()){
            return null;
        }

        return regionOpt.get();
    }

    public Region create(Region region) {
        
        return regionRepository.save(region);
    }

    public Region update(Region region) {
        
        return regionRepository.save(region);
    }

    public void deleteById(Integer id) {
        regionRepository.deleteById(id);
    }

    public void delete(Region region) {
        regionRepository.delete(region);
    }
}
