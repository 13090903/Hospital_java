package ru.vsu.csf.service;

import ru.vsu.csf.dto.DepartmentDto;
import ru.vsu.csf.dto.PatientDto;
import ru.vsu.csf.model.Department;
import ru.vsu.csf.model.Patient;

import java.util.Set;

public interface DepartmentService {
    Department create(String name);

    Department findByName(String name);
    Department findById(int id);

    Department removeById(int id);
    Department removeByName(String name);

    Department updateById(int id, String name);
    Department updateByName(String name, String newName);

    void addPatient(int departmentId, int patientId);

    void removePatient(int departmentId, int patientId);

}
