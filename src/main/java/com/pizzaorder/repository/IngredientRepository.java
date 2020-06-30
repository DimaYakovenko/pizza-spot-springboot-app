package com.pizzaorder.repository;

import com.pizzaorder.business.Ingredient;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface IngredientRepository extends JpaRepository<Ingredient, String> {
   /*
    methods for JDBC implementation
    List<Ingredient> findAll();

    Ingredient findOne(String id);

    Ingredient save(Ingredient ingredient);*/
}
