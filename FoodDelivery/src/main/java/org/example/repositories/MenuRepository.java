package org.example.repositories;

import org.example.models.Dish;
import org.example.models.Menu;

import java.util.ArrayList;
import java.util.List;

public class MenuRepository {
    // Store all the menu available in the app
    // Handle the operations like : Add dish to a menu, remove dish from a menu, update dish from a menu
    private List<Menu> menuList;

    public MenuRepository() {
        this.menuList = new ArrayList<>();
    }

    public void addDishToMenu(int menuId, Dish dish){
        for(Menu menu : this.menuList){
            if (menu.getId() == menuId) {
                menu.addDishToMenu(dish);
            }
        }
    }
    public void removeDishFromMenu(int menuId, Dish dish){
        for(Menu menu : this.menuList){
            if (menu.getId() == menuId) {
                menu.removeDishFromMenu(dish.getId());
            }
        }
    }
}
