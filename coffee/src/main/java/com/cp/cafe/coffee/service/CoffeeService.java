package com.cp.cafe.coffee.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.cp.cafe.coffee.model.Coffee;

@Service
public class CoffeeService {
    private final List<Coffee> coffees = new ArrayList<>();
    private int nextId = 1;

    public CoffeeService() {
        addCoffee(new Coffee("Espresso", 45.0));
        addCoffee(new Coffee("Latte", 55.0));
    }

    public List<Coffee> getAllCoffees() {
        return coffees;
    }

    public Coffee getCoffeeById(int id) {
        for (Coffee coffee : coffees) {
            if (coffee.getId() == id) {
                return coffee;
            }
        }
        return null;
    }

    public Coffee addCoffee(Coffee coffee) {
        if (coffee == null) {
            throw new IllegalArgumentException("Coffee cannot be null");
        }

        coffee.setId(nextId++);
        coffees.add(coffee);
        return coffee;
    }

    public Coffee updateCoffee(int id, Coffee updatedCoffee) {
        if (updatedCoffee == null) {
            throw new IllegalArgumentException("Updated coffee cannot be null");
        }

        for (Coffee coffee : coffees) {
            if (coffee.getId() == id) {
                coffee.setName(updatedCoffee.getName());
                coffee.setPrice(updatedCoffee.getPrice());
                return coffee;
            }
        }

        return null;
    }

    public boolean deleteCoffee(int id) {
        return coffees.removeIf(coffee -> coffee.getId() == id);
    }

    public List<Coffee> searchCoffeeByName(String name) {
        List<Coffee> results = new ArrayList<>();
        for (Coffee coffee : coffees) {
            if (coffee.getName().toLowerCase().contains(name.toLowerCase())) {
                results.add(coffee);
            }
        }
        return results;
    }
}
