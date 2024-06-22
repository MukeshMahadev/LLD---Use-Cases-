package models;

import services.PatientService;

import java.util.ArrayList;
import java.util.List;

public class Patient {
    private String name;

    private int id;

    private List<Appointment> appointments;

    public Patient(){
        this.appointments= new ArrayList<>();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public List<Appointment> getAppointments() {
        return appointments;
    }

    public void setAppointments(List<Appointment> appointments) {
        this.appointments = appointments;
    }

    @Override
    public String toString() {
        return "Patient : {id:" +this.id+
                ", name: " + this.name +
                '}';
    }
}
