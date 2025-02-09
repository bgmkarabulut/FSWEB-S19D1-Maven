package com.workintech.s18d2.dao;

import com.workintech.s18d2.entity.Fruit;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface FruitRepository extends CrudRepository<Fruit,Long> {
    @Query("SELECT f FROM Fruit f ORDER BY f.price DESC")
    List<Fruit> getByPriceDesc();

    // Ücrete göre artan sırada tüm meyveler
    @Query("SELECT f FROM Fruit f ORDER BY f.price ASC")
    List<Fruit> getByPriceAsc();

    // İsme göre filtreleme
    @Query("SELECT f FROM Fruit f WHERE LOWER(f.name) LIKE LOWER(CONCAT('%', :name, '%'))")
    List<Fruit> searchByName(String name);


}
