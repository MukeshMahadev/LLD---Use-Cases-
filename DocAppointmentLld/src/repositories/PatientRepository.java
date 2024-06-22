package repositories;

import enums.Specialization;
import exceptions.RegistrationException;
import models.Doctor;
import models.Patient;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class PatientRepository {
    public List<Patient> getPatients() {
        return patients;
    }

    public void setPatients(List<Patient> patients) {
        this.patients = patients;
    }

    private List<Patient> patients = new ArrayList<>();

    // Register
    public void registerPatient(Patient patient) throws RegistrationException {
        patients.add(patient);
    }
}
