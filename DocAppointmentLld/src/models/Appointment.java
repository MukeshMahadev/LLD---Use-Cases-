package models;

public class Appointment {
    private TimeSlot timeslot;
    private Doctor doctor;
    private Patient patient;

    private Boolean reserved;

    public Appointment(TimeSlot timeslot, Doctor doctor) {
        // initialising TimeSlot and Doctor because Doctor adds the TimeSlot as when he is available.
        // Patient might not be assigned to the Appointment
        this.timeslot = timeslot;
        this.doctor = doctor;
        this.reserved = Boolean.FALSE;
    }

    public TimeSlot getTimeslot() {
        return timeslot;
    }

    public void setTimeslot(TimeSlot timeslot) {
        this.timeslot = timeslot;
    }

    public Doctor getDoctor() {
        return doctor;
    }

    public void setDoctor(Doctor doctor) {
        this.doctor = doctor;
    }

    public Patient getPatient() {
        return patient;
    }

    public void setPatient(Patient patient) {
        this.patient = patient;
    }

    public Boolean getReserved() {
        return this.reserved;
    }

    public void setReserved(Boolean reserved) {
        this.reserved = reserved;
    }

    @Override
    public String toString() {
        return "Appointment: {start:" +this.timeslot.getStart()+
                ", doctor: " + this.doctor.getName() +
                ", patient:'" + this.patient+
                ", isReserved:'" + this.reserved +
                '}';
    }
}
