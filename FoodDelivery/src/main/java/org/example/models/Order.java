package org.example.models;

import org.example.models.enums.OrderStatus;

import java.util.List;

public class Order {
    private int orderId;
    private User user;
    private Restaurant restaurant;
    private List<Integer>  dishes;
    private Location sourceLocation;
    private Location deliveryLocation;

    private OrderStatus orderStatus;

    public Order(int orderId, User user, Restaurant restaurant, List<Integer> dishes, Location sourceLocation, Location deliveryLocation, OrderStatus orderStatus) {
        this.orderId = orderId;
        this.user = user;
        this.restaurant = restaurant;
        this.dishes = dishes;
        this.sourceLocation = sourceLocation;
        this.deliveryLocation = deliveryLocation;
        this.orderStatus = orderStatus;
    }

    public OrderStatus getOrderStatus() {
        return orderStatus;
    }

    public void setOrderStatus(OrderStatus orderStatus) {
        this.orderStatus = orderStatus;
    }

    public int getOrderId() {
        return orderId;
    }

    public void setOrderId(int orderId) {
        this.orderId = orderId;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Restaurant getRestaurant() {
        return restaurant;
    }

    public void setRestaurant(Restaurant restaurant) {
        this.restaurant = restaurant;
    }

    public List<Integer> getDishes() {
        return dishes;
    }

    public void setDishes(List<Integer> dishes) {
        this.dishes = dishes;
    }

    public Location getSourceLocation() {
        return sourceLocation;
    }

    public void setSourceLocation(Location sourceLocation) {
        this.sourceLocation = sourceLocation;
    }

    public Location getDeliveryLocation() {
        return deliveryLocation;
    }

    public void setDeliveryLocation(Location deliveryLocation) {
        this.deliveryLocation = deliveryLocation;
    }
}
