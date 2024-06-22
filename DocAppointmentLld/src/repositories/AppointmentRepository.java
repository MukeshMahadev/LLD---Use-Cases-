package repositories;

import Utils.RankingStrategy;
import enums.RankingPreference;
import enums.Specialization;
import exceptions.AppointmentBookingFailedException;
import exceptions.DoctorNotFoundException;
import models.Appointment;
import models.Doctor;
import models.Patient;
import models.TimeSlot;

import javax.print.Doc;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class AppointmentRepository {
    // Inject the doctor and patient repository as they have some utility functions
    private DoctorRepository doctorRepository;
    private PatientRepository patientRepository;

    private RankingStrategy rankingStrategy;

    public AppointmentRepository(DoctorRepository doctorRepository, PatientRepository patientRepository, RankingStrategy rankingStrategy) {
        this.doctorRepository = doctorRepository;
        this.patientRepository = patientRepository;
        this.rankingStrategy = rankingStrategy;
    }

    // Search for available appointments based on specialty
    public List<Appointment> getAppointments(Specialization specialty, RankingPreference rankingPreference) throws DoctorNotFoundException{
        // Get the doctors
        List<Doctor> specialtyDoctors = doctorRepository.getDoctorsBySpecialty(specialty);
        // Get the list of slots for all the doctors
        List<Appointment> appointments = new ArrayList<>();
        appointments = doctorRepository.getAvailableAppointments(specialtyDoctors);
        // Rank the appointment slots
        if (rankingPreference == RankingPreference.TIMESLOT){
            appointments = rankingStrategy.rank(appointments);
        }
        return appointments;
    }


    // Book a appointment
    public void bookAppointment(Appointment appointment, Patient patient){
        // Conditions to be checked : doctor is booked => not required because ge available gets only unreserved slots
        // patient has booked a time slot where the start time matches => Slot Already Booked
        for (Appointment patientAppointment:patient.getAppointments()) {
            if(appointment.getTimeslot().getStart().equals(patientAppointment.getTimeslot().getStart())){
                throw new AppointmentBookingFailedException();
            }
        }
        appointment.setReserved(Boolean.TRUE);

        // Add it to the doctor's appointment List - Not Required as it's added when the doctor creates the appointment
        // Add it to the patient's appointment List
        patient.getAppointments().add(appointment);
    }


}
