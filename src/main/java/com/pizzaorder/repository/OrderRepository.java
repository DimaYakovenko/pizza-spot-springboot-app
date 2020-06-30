package com.pizzaorder.repository;

import com.pizzaorder.business.Order;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface OrderRepository extends CrudRepository<Order, Long> {

    List<Order> findByDeliveryCity(String city);

    /*
        methods for JDBC implementation
    Order save(Order order);*/
}
