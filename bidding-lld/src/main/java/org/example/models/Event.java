package org.example.models;

import org.example.models.enums.EventType;

public class Event {
    private EventType eventType;
    private String message;

    public Event(EventType eventType, String message) {
        this.eventType = eventType;
        this.message = message;
    }

    public EventType getEventType() {
        return eventType;
    }

    public void setEventType(EventType eventType) {
        this.eventType = eventType;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
