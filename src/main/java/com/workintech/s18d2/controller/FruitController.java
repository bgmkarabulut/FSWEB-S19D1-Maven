package com.workintech.s18d2.controller;

import com.workintech.s18d2.entity.Fruit;
import com.workintech.s18d2.exceptions.FruitException;
import com.workintech.s18d2.exceptions.PlantException;
import com.workintech.s18d2.services.FruitService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class FruitController {

    @Autowired
    private FruitService fruitService;

    @GetMapping("/workintech/fruits")
    List<Fruit> getAllFruits(){
    return fruitService.getByPriceAsc();
    }

    @GetMapping("/workintech/fruits/{id}")
    public Fruit getFruitById(@PathVariable Long id) throws FruitException {
        if (id<0){
            throw new FruitException("ID is incorrect");
        }
    Fruit fruit= fruitService.getById(id);

        if(fruit==null){
            throw new FruitException("Fruit not found");
        }
        return fruit;
    }

    @GetMapping("/workintech/fruits/desc")
    List<Fruit> getAllFruitsByDesc(){
        return fruitService.getByPriceDesc();
    }

    @PostMapping("/workintech/fruits")
    public void saveOrupdate(@RequestBody Fruit fruit){
        fruitService.save(fruit);
    }

    @PostMapping("/workintech/fruits/{name}")
    List<Fruit> getFruitsByName(@PathVariable String name){
        return fruitService.searchByName(name);
    }

    @DeleteMapping("/workintech/fruits/{id}")
    public Fruit deleteById(@PathVariable Long id)throws PlantException{
        if (id<0){
            throw new PlantException();
        }
        return fruitService.delete(id);
    }

}
