/*
package com.pizzaorder.repository;

import com.pizzaorder.business.Ingredient;
import com.pizzaorder.business.Pizza;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementCreator;
import org.springframework.jdbc.core.PreparedStatementCreatorFactory;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Repository;

import java.sql.Types;
import java.util.Arrays;
import java.util.Date;

@Repository
public class PizzaJdbcRepositoryImpl implements PizzaRepository {

    JdbcTemplate jdbcTemplate;

    @Autowired
    public PizzaJdbcRepositoryImpl(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public Pizza save(Pizza pizza) {
        long pizzaId = savePizza(pizza);
        pizza.setId(pizzaId);
        for (Ingredient ingredient : pizza.getIngredients()) {
            saveIngredientToPizza(ingredient, pizzaId);
        }
        return pizza;
    }

    private long savePizza(Pizza pizza) {
        pizza.setCreatedAt(new Date());
        PreparedStatementCreatorFactory preparedStatementCreatorFactory =
                new PreparedStatementCreatorFactory(
                        "insert into Pizza (name, createdAt) values (?, ?)", Types.VARCHAR, Types.TIMESTAMP);

        preparedStatementCreatorFactory.setReturnGeneratedKeys(true);

        PreparedStatementCreator psc = preparedStatementCreatorFactory.newPreparedStatementCreator(
                Arrays.asList(
                        pizza.getName(),
                        pizza.getCreatedAt())
        );

        KeyHolder keyHolder = new GeneratedKeyHolder();
        jdbcTemplate.update(psc, keyHolder);
        return keyHolder.getKey().longValue();
    }

    private void saveIngredientToPizza(Ingredient ingredient, long pizzaId) {
        jdbcTemplate.update("insert into Pizza_Ingredients (pizza, ingredient) values (?, ?)", pizzaId, ingredient.getId());
    }
}
*/
