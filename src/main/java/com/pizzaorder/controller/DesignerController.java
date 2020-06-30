package com.pizzaorder.controller;

import com.pizzaorder.business.Ingredient;
import com.pizzaorder.business.Ingredient.Type;
import com.pizzaorder.business.Order;
import com.pizzaorder.business.Pizza;
import com.pizzaorder.repository.IngredientRepository;
import com.pizzaorder.repository.PizzaRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;

import javax.validation.Valid;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@Controller
@Slf4j
@RequestMapping("/designer")
@SessionAttributes("order")
public class DesignerController {

    IngredientRepository ingredientRepository;

    PizzaRepository pizzaRepository;

    @Autowired
    public DesignerController(IngredientRepository ingredientRepository, PizzaRepository pizzaRepository) {
        this.ingredientRepository = ingredientRepository;
        this.pizzaRepository = pizzaRepository;
    }

    @ModelAttribute(name = "pizza")
    public Pizza pizzaAttr() {
        return new Pizza();
    }

    @ModelAttribute(name = "order")
    public Order orderAttr() {
        return new Order();
    }

    @ModelAttribute
    public void addIngredientsAttributes(Model model) {
        List<Ingredient> ingredients = ingredientRepository.findAll();
        Type[] types = Type.values();
        Arrays.stream(types)
                .forEach(type -> model.addAttribute(type.toString().toLowerCase(), filterByType(type, ingredients)));
    }
    @GetMapping
    public String showDesignerForm(Model model) {
        return "designer";
    }

    @PostMapping
    public String processSubmission(@Valid Pizza design, Errors errors, @ModelAttribute Order order) {
        if (errors.hasErrors()) {
            return "designer";
        }
        Pizza saved = pizzaRepository.save(design);
        order.addDesign(saved);
        return "redirect:/orders/current";
    }

    private List<Ingredient> filterByType(Type type, List<Ingredient> ingredients) {
        return ingredients.stream()
                .filter(ingredient -> ingredient.getType().equals(type))
                .collect(Collectors.toList());
    }
}
