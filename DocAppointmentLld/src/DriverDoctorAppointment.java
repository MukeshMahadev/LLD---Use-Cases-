import Utils.RankingStrategy;
import Utils.TimeSlotRanking;
import enums.Specialization;
import exceptions.AppointmentBookingFailedException;
import models.Appointment;
import models.Doctor;
import models.Patient;
import models.TimeSlot;
import repositories.AppointmentRepository;
import repositories.DoctorRepository;
import repositories.PatientRepository;
import services.PatientService;

import java.time.LocalDateTime;
import java.util.List;

public class DriverDoctorAppointment {

    public void test(){

        // This class would be responsible for creating the services and demonstrate the below operations
        // 1. Create 2 doctors for two specialties using the doctor service
        // 2. Add free slot for doctor using the doctor service
        // 3. Add an appointment for a doctor
        // 4. Search the slots based on specialties. (Show that the results are ranked on the basis of time)
        // 5. Select one of the slot and book an appointment
        // 6. Try to book an appointment with other doctor in the same slot. => This should throw an exception
        // 7. cancel the apppointment
        // 8. book an appointment => Booking should be successful
        // 9.

        DoctorRepository doctorRepository = new DoctorRepository();
        PatientRepository patientRepository = new PatientRepository();

        Doctor doc1 = new Doctor("1","doc1", Specialization.GENERAL_PHYSICIAN);
        Doctor doc2 = new Doctor("2","doc2", Specialization.GENERAL_PHYSICIAN);

        Doctor doc3 = new Doctor("3","doc3", Specialization.CARDIOLOGIST);
        Doctor doc4 = new Doctor("4","doc4", Specialization.CARDIOLOGIST);

        doctorRepository.registerDoctor(doc1);
        doctorRepository.registerDoctor(doc2);
        doctorRepository.registerDoctor(doc3);
        doctorRepository.registerDoctor(doc4);

        Patient patient1 = new Patient();
        Patient patient2 = new Patient();

        patientRepository.registerPatient(patient1);
        patientRepository.registerPatient(patient2);


        // Get the available slots and print them
        List<Doctor> doctors = doctorRepository.getDoctorsBySpecialty(Specialization.GENERAL_PHYSICIAN);
        System.out.println("General Physician");
        for (Doctor doc:
                doctors) {
            System.out.println(doc);

        }
        // Add a time slot to doc 1
        TimeSlot timeSlot1 = new TimeSlot(LocalDateTime.now().withHour(9).withMinute(00),LocalDateTime.now().withHour(9).withMinute(30));
        doctorRepository.addFreeSlot(timeSlot1,doc1);

        TimeSlot timeSlot2 = new TimeSlot(LocalDateTime.now().withHour(9).withMinute(30),LocalDateTime.now().withHour(10).withMinute(00));
        doctorRepository.addFreeSlot(timeSlot2,doc1);

        //Get Available slots
        List<Appointment> genPhyAppointments = doctorRepository.getAvailableAppointments(doctors);
        for (Appointment app: genPhyAppointments
             ) {
            System.out.println(app);
        }

        // Ranking Strategy
        RankingStrategy rankingStrategy = new TimeSlotRanking();

        //Book a appointment for Patient 1
        AppointmentRepository appointmentRepository = new AppointmentRepository(doctorRepository,patientRepository,rankingStrategy);

        appointmentRepository.bookAppointment(doc1.getAppointments().get(1),patient1);

        // Confirm
        System.out.println(doc1.getAppointments().get(1));

        try {
            appointmentRepository.bookAppointment(doc1.getAppointments().get(1),patient1);
        }
        catch (AppointmentBookingFailedException apf){
            System.out.println("Appointment Booking failed for patient2");
        }
        appointmentRepository.bookAppointment(doc1.getAppointments().get(0),patient2);
        System.out.println("Appointment booking succeeded for other slot");
    }
}
