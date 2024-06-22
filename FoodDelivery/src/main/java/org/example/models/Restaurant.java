package org.example.models;

public class Restaurant {
    private int id;
    private String restaurantName;

    public Restaurant(int id, String restaurantName) {
        this.id = id;
        this.restaurantName = restaurantName;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getRestaurantName() {
        return restaurantName;
    }

    public void setRestaurantName(String restaurantName) {
        this.restaurantName = restaurantName;
    }
}
