package org.example.models;

public class Location {

    private int id;
    private Long Latitude;
    private Long Longitude;

    public Location(Long latitude, Long longitude) {
        Latitude = latitude;
        Longitude = longitude;
    }

    public Long getLatitude() {
        return Latitude;
    }

    public void setLatitude(Long latitude) {
        Latitude = latitude;
    }

    public Long getLongitude() {
        return Longitude;
    }

    public void setLongitude(Long longitude) {
        Longitude = longitude;
    }
}
