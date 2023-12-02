package ru.vsu.csf.service;

import ru.vsu.csf.model.Department;

public interface DepartmentService extends HospitalService<Department>{
    void create(String name);

    Department findByName(String name);
    Department removeByName(String name);

    void updateById(int id, String name);
    Department updateByName(String name, String newName);

    void addPatient(int departmentId, int patientId);

    void removePatient(int departmentId, int patientId);

}
