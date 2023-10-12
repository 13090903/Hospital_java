package ru.vsu.csf.repository;

import ru.vsu.csf.model.Department;
import ru.vsu.csf.model.Patient;

import java.util.Set;

public interface PatientRepository extends HospitalRepository<Patient> {
    Patient deleteByFullName(String firstName, String lastName, String patronymic);
    Patient findByFullName(String firstName, String lastName, String patronymic);
}
