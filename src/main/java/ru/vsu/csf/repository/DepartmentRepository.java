package ru.vsu.csf.repository;

import ru.vsu.csf.model.Department;

import java.util.Set;

public interface DepartmentRepository extends HospitalRepository<Department>{
    Department deleteByName(String name);
    Department findByName(String name);
    int countNumberOfPatients(int id);
    void addPatient(int departmentId, int patientId);
    void removePatient(int departmentId, int patientId);
}
