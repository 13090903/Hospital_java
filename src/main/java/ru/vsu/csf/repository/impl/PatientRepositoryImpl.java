package ru.vsu.csf.repository.impl;

import ru.vsu.csf.model.Patient;
import ru.vsu.csf.repository.HospitalRepository;
import ru.vsu.csf.repository.PatientRepository;

import java.util.Set;

public class PatientRepositoryImpl implements PatientRepository {
    private final Set<Patient> patients;

    private static PatientRepositoryImpl instance;

    public static PatientRepositoryImpl getInstance(Set<Patient> patients) {
        if (instance == null)
            instance = new PatientRepositoryImpl(patients);

        return instance;
    }

    private PatientRepositoryImpl(Set<Patient> patients) {
        this.patients = patients;
    }

    @Override
    public Patient findById(int id) {
        for (Patient patient : patients) {
            if (patient.getId() == id) {
                return patient;
            }
        }
        return null;
    }

    @Override
    public Patient deleteById(int id) {
        Patient patient = findById(id);
        patients.remove(patient);
        return patient;
    }

    @Override
    public Patient deleteByFullName(String firstName, String lastName, String patronymic) {
        Patient patient = findByFullName(firstName, lastName, patronymic);
        patients.remove(patient);
        return patient;
    }

    @Override
    public Set<Patient> findAll() {
        return patients;
    }

    @Override
    public Patient findByFullName(String firstName, String lastName, String patronymic) {
        for (Patient patient : patients) {
            if (patient.getFirstName().equals(firstName) && patient.getLastName().equals(lastName) && patient.getPatronymic().equals(patronymic)) {
                return patient;
            }
        }
        return null;
    }
}
