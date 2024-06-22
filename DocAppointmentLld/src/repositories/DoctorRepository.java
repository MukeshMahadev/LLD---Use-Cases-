package repositories;

import exceptions.AppointmentNotFoundException;
import exceptions.DoctorNotFoundException;
import exceptions.RegistrationException;
import models.Appointment;
import models.Doctor;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import enums.Specialization;
import models.TimeSlot;

public class DoctorRepository {
    // This will contain the methods to support the below
    // 1. registering a doctor => Adding the doctor to the specialty map
    // 2. Addition of free slots by the doctor => add the slots to the appointments, doctor object
    // 3. Searching a doctor based on the speciality => Filter the Specialty Map,
    // 4. Get the Available timeslots of a doctor and give it back, Service will take of ranking the results based on the given condition
    // 5. Return the available slots for a specialty


    // This will also contain the mapping of the specialty to doctor list
    // timeslot to doctor list

    // List of Specialty => Doctor Mapping
    private HashMap<Specialization, List<Doctor>> specializationDoctorMap = new HashMap<>();

    // Registering a user is adding a doctor to a map
    public void registerDoctor(Doctor doctor) throws RegistrationException{
        if (!specializationDoctorMap.containsKey(doctor.getSpecialty())){
            // Create the key and add the doctor
            List<Doctor> doctorlist = new ArrayList<Doctor>();
            doctorlist.add(doctor);
            specializationDoctorMap.put(doctor.getSpecialty(), doctorlist);
        }
        specializationDoctorMap.get(doctor.getSpecialty()).add(doctor);
    }

    public void addFreeSlot(TimeSlot timeSlot, Doctor doctor){
        // Create a appointment object
        Appointment appointment = new Appointment(timeSlot, doctor);
        // Add it to the doctor's appointments List
        doctor.getAppointments().add(appointment);
    }



    public List<Doctor> getDoctorsBySpecialty(Specialization specialty) {
        // if specialty is present as key return the list
        if(specializationDoctorMap.containsKey(specialty)){
            return specializationDoctorMap.get(specialty);
        }
        throw new DoctorNotFoundException();
    }

    public List<Appointment> getAvailableAppointments(List<Doctor> doctorList){
        List<Appointment> appointments = new ArrayList<>();
        // Get the appointment for the list of doctor => because Appointment Repository will always send a List
        for (Doctor doctor: doctorList) {
            if (doctor.getAppointments().size() > 0){
                // Iterate through the list using a for loop
                for (Appointment appointment: doctor.getAppointments()) {
                    if(!appointment.getReserved()){
                        appointments.add(appointment);
                    }
                }

            }
        }
        return appointments;
    }

}
