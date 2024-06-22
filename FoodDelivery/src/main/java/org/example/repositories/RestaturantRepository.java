package org.example.repositories;

import org.example.models.Restaurant;

import java.util.ArrayList;
import java.util.List;

public class RestaturantRepository {
    // contains a list of Restaturants
    // add or remove or update restaurants from the List

    private List<Restaurant> restaurantList;

    public RestaturantRepository() {
        this.restaurantList = new ArrayList<>();
    }

    public List<Restaurant> getRestaurantList() {
        return restaurantList;
    }

    public void addRestaurant(Restaurant restaurant){
        this.restaurantList.add(restaurant);
    }

    public void removeRestaurant(int restaurantId){
        this.restaurantList.removeIf(restaurant -> restaurant.getId() == restaurantId);
    }

}
