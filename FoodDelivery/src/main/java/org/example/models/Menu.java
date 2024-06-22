package org.example.models;

import java.util.ArrayList;
import java.util.List;

public class Menu {
    private int id;
    private List<Dish> dishes;

    public Menu() {
        this.dishes = new ArrayList<>();
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public List<Dish> getDishes() {
        return dishes;
    }

    public void setDishes(List<Dish> dishes) {
        this.dishes = dishes;
    }

    public void addDishToMenu(Dish dish){
        this.dishes.add(dish);
    }

    public void removeDishFromMenu(int dishId){
        this.dishes.removeIf(dish-> dish.getId() == dishId);
    }
}
