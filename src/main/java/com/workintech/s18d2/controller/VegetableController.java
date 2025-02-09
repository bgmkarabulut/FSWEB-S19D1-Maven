package com.workintech.s18d2.controller;

import com.workintech.s18d2.entity.Fruit;
import com.workintech.s18d2.entity.Vegetable;
import com.workintech.s18d2.services.VegetableService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class VegetableController {

    @Autowired
    private VegetableService vegetableService;

    @GetMapping("/workintech/vegetables")
    List<Vegetable> getAllFruits(){
        return vegetableService.getByPriceAsc();
    }

    @GetMapping("/workintech/vegetables/{id}")
    public Vegetable getFruitById(@PathVariable Long id){
        return vegetableService.getById(id);
    }

    @GetMapping("/workintech/vegetables/desc")
    List<Vegetable> getAllFruitsByDesc(){
        return vegetableService.getByPriceDesc();
    }

    @PostMapping("/workintech/vegetables")
    public void saveOrupdate(@RequestBody Vegetable vegetable){
        vegetableService.save(vegetable);
    }
}
