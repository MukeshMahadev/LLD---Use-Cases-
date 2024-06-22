package models;

import enums.Specialization;

import java.util.ArrayList;
import java.util.List;

public class Doctor {
    private String id;
    private String name;
    private Specialization specialty;
    private Float rating;
    private List<Appointment> appointments;

    public Doctor(String id, String name, Specialization specialty) {
        this.id = id;
        this.name = name;
        this.specialty = specialty;
        this.appointments = new ArrayList<>();
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Specialization getSpecialty() {
        return specialty;
    }

    public void setSpecialty(Specialization specialty) {
        this.specialty = specialty;
    }

    public Float getRating() {
        return rating;
    }

    public void setRating(Float rating) {
        this.rating = rating;
    }

    public List<Appointment> getAppointments() {
        return appointments;
    }

    public void setAppointments(List<Appointment> appointments) {
        this.appointments = appointments;
    }

    @Override
    public String toString() {
        return "Doctor: {id:" +this.id+
                ", name: " + this.name +
                ", specialization='" + this.specialty+
                '}';
    }
}
