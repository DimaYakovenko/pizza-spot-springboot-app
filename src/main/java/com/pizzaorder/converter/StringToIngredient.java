package com.pizzaorder.converter;

import com.pizzaorder.business.Ingredient;
import com.pizzaorder.repository.IngredientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class StringToIngredient implements Converter<String, Ingredient> {

    @Autowired
    IngredientRepository ingredientRepository;

    @Override
    public Ingredient convert(String id) {
        Optional<Ingredient> one = ingredientRepository.findById(id);
        return one.orElse(null);
    }
}
