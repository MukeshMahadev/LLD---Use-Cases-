package org.example.models.interfaces;

import org.example.models.Event;
import org.example.models.User;

public interface Observable {
    public void notifyObservers(Event event);
    public void subscribe(User user);
    public void unsubscribe(User user);
}
