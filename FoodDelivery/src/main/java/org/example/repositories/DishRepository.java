package org.example.repositories;

import org.example.models.Dish;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class DishRepository {
    private List<Dish> dishes;

    public DishRepository() {
        this.dishes = new ArrayList<Dish>();
    }

    public List<Dish> getDishes() {
        return dishes;
    }

    public void setDishes(List<Dish> dishes) {
        this.dishes = dishes;
    }

    public void addDish(Dish dish) {
        this.dishes.add(dish);
    }

    public void removeDish(int dishId){
        dishes.removeIf(dish -> dish.getId() == dishId);

    }
}
