package com.workintech.s18d2.services;

import com.workintech.s18d2.entity.Fruit;
import com.workintech.s18d2.entity.Vegetable;

import java.util.List;

public interface VegetableService {
    public Vegetable getById(Long id);
    public List<Vegetable> getByPriceAsc();
    public List<Vegetable> getByPriceDesc();
    public List<Vegetable> searchByName(String name);
    public Vegetable save(Vegetable vegetable);
    public Vegetable delete(Long id);
}
