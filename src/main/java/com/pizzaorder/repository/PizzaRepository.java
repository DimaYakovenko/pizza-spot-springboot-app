package com.pizzaorder.repository;

import com.pizzaorder.business.Pizza;
import org.springframework.data.repository.CrudRepository;

public interface PizzaRepository  extends CrudRepository<Pizza, Long> {

   /*
       methods for JDBC implementation
   Pizza save(Pizza pizza);*/
}
