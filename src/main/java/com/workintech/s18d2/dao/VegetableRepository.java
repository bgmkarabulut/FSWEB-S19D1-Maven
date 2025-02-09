package com.workintech.s18d2.dao;

import com.workintech.s18d2.entity.Vegetable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface VegetableRepository extends CrudRepository<Vegetable,Long> {
    @Query("SELECT v FROM Vegetable v ORDER BY v.price DESC")
    List<Vegetable> getByPriceDesc();

    // Ücrete göre artan sırada tüm sebzeler
    @Query("SELECT v FROM Vegetable v ORDER BY v.price ASC")
    List<Vegetable> getByPriceAsc();

    // İsme göre filtreleme
    @Query("SELECT v FROM Vegetable v WHERE LOWER(v.name) LIKE LOWER(CONCAT('%', :name, '%'))")
    List<Vegetable> searchByName(String name);

}
