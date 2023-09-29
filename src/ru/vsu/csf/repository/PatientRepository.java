package ru.vsu.csf.repository;

import ru.vsu.csf.model.Department;
import ru.vsu.csf.model.Patient;

import java.util.Set;

public interface PatientRepository {
    Patient findById(int id);
    Patient deleteById(int id);
    Patient deleteByFullName(String firstName, String lastName, String patronymic);
    Set<Patient> findAll();
    Patient findByFullName(String firstName, String lastName, String patronymic);
}
