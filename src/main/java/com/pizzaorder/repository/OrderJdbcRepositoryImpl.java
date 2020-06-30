/*
package com.pizzaorder.repository;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.pizzaorder.business.Order;
import com.pizzaorder.business.Pizza;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.simple.SimpleJdbcInsert;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Repository
public class OrderJdbcRepositoryImpl implements OrderRepository {

    private static final String ORDER_TABLE_NAME = "Pizza_Order";
    private static final String PIZZA_ORDERS_TABLE_NAME = "Pizza_Order_Pizzas";

    SimpleJdbcInsert orderInserter;
    SimpleJdbcInsert pizzaOrderInserter;
    ObjectMapper objectMapper;

    @Autowired
    public OrderJdbcRepositoryImpl(JdbcTemplate jdbcTemplate) {
        this.orderInserter = new SimpleJdbcInsert(jdbcTemplate)
                .withTableName(ORDER_TABLE_NAME)
                .usingGeneratedKeyColumns("id");

        this.pizzaOrderInserter = new SimpleJdbcInsert(jdbcTemplate)
                .withTableName(PIZZA_ORDERS_TABLE_NAME);

        this.objectMapper = new ObjectMapper();

    }

    @Override
    public Order save(Order order) {
        order.setPlacedAt(new Date());
        long orderId = saveOrderDetails(order);
        order.setId(orderId);
        List<Pizza> pizzas = order.getPizzas();
        for (Pizza pizza : pizzas) {
            savePizzaToOrder(pizza, orderId);
        }
        return order;
    }

    private long saveOrderDetails(Order order) {
        Map<String, Object> values = objectMapper.convertValue(order, Map.class);
        values.put("placedAt", order.getPlacedAt());

        long orderId = orderInserter
                .executeAndReturnKey(values)
                .longValue();
        return orderId;
    }

    private void savePizzaToOrder(Pizza pizza, long orderId) {
        Map<String, Object> values = new HashMap<>();
        values.put("pizzaOrder", orderId);
        values.put("pizza", pizza.getId());
        pizzaOrderInserter.execute(values);
    }
}
*/
