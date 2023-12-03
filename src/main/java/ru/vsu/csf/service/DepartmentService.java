package ru.vsu.csf.service;

import ru.vsu.csf.model.Department;

public interface DepartmentService extends HospitalService<Department>{
    void create(String name);

    Department findByName(String name);

    void updateById(int id, String name);

    void addPatient(int departmentId, int patientId);

    void removePatient(int departmentId, int patientId);

}
