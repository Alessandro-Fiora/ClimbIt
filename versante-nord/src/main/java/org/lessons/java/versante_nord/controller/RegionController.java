package org.lessons.java.versante_nord.controller;

import java.util.List;


import org.lessons.java.versante_nord.model.Region;
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
@RequestMapping("/regions")
public class RegionController {
    
    @Autowired
    private RegionService regionService;

    @GetMapping
    public String index(Model model) {

        List<Region> regions = regionService.findAll();
        model.addAttribute("regions", regions);
        
        return "regions/index";
    }

    @GetMapping("/{id}")
    public String show(@PathVariable Integer id, Model model) {
        Region region = regionService.getById(id);
        model.addAttribute("region", region);
        
        return "regions/show";
    }

    @GetMapping("/create")
    public String create(Model model){
        Region region = new Region();
        model.addAttribute("region", region);
        return "regions/create-or-edit";
    }

    @GetMapping("/search")
    public String search(@RequestParam("query") String query, Model model) {
        List<Region> regions = regionService.findByName(query);
        model.addAttribute("regions", regions);
        
        return "regions/index";
    }

    @PostMapping("/create")
    public String store(@Valid @ModelAttribute("region") Region formRegion, BindingResult bindingResult, Model model ) {
        
        if(bindingResult.hasErrors()){
            return "regions/create-or-edit";
        }

        regionService.create(formRegion);

        return "redirect:/regions";
    }

    @GetMapping("/edit/{id}")
    public String edit(@PathVariable Integer id, Model model) {
        model.addAttribute("edit", true);
        model.addAttribute("region", regionService.getById(id));

        return "regions/create-or-edit";
    }

    @PostMapping("/edit/{id}")
    public String update(@Valid @ModelAttribute("region") Region formRegion, BindingResult bindingResult, Model model ) {
        if(bindingResult.hasErrors()){
            return "regions/create-or-edit";
        }
        regionService.update(formRegion);
        
        return "redirect:/regions";
    }

    @PostMapping("/delete/{id}")
    public String delete(@PathVariable Integer id){
        
        regionService.deleteById(id);

        return "redirect:/regions";
    }

}
