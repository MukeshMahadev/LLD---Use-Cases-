package org.example.models;

import org.example.models.interfaces.Observable;

import java.util.ArrayList;
import java.util.List;

public class Publisher implements Observable {
    private List<User> subscibersList;

    public Publisher() {
        this.subscibersList = new ArrayList<>();
    }

    @Override
    public void notifyObservers(Event event) {
        for (User user: subscibersList
             ) {
             user.update(event);
        }

    }

    @Override
    public void subscribe(User user) {
        subscibersList.add(user);
    }

    @Override
    public void unsubscribe(User u) {
        subscibersList.remove(u);

    }
    // Will implement the observable class and implement notify()
}
