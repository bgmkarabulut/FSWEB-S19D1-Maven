package com.workintech.s18d2.services;

import com.workintech.s18d2.dao.VegetableRepository;
import com.workintech.s18d2.entity.Fruit;
import com.workintech.s18d2.entity.Vegetable;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
@Component
public class VegetableServiceImpl implements VegetableService{
    private VegetableRepository vegetableRepository;
    @Autowired
    public VegetableServiceImpl(VegetableRepository vegetableRepository) {
        this.vegetableRepository = vegetableRepository;
    }

    @Override
    public Vegetable getById(Long id) {
        return this.vegetableRepository.findById(id).orElse(null);
    }

    @Override
    public List<Vegetable> getByPriceAsc() {
        return this.vegetableRepository.getByPriceAsc();
    }

    @Override
    public List<Vegetable> getByPriceDesc() {
        return this.vegetableRepository.getByPriceDesc();
    }

    @Override
    public List<Vegetable> searchByName(String name) {
        return this.vegetableRepository.searchByName(name);
    }

    @Override
    public Vegetable save(Vegetable vegetable) {
        return this.vegetableRepository.save(vegetable);
    }

    @Override
    public Vegetable delete(Long id) {
       Vegetable vegToDelete=getById(id);
        this.vegetableRepository.delete(vegToDelete);
        return vegToDelete;
    }
}
