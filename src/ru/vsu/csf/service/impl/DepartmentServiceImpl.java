package ru.vsu.csf.service.impl;

//import ru.vsu.csf.dto.DepartmentDto;
//import ru.vsu.csf.dto.PatientDto;
import ru.vsu.csf.model.Department;
import ru.vsu.csf.model.Patient;
import ru.vsu.csf.repository.DepartmentRepository;
import ru.vsu.csf.repository.PatientRepository;
import ru.vsu.csf.repository.impl.DepartmentRepositoryImpl;
import ru.vsu.csf.repository.impl.PatientRepositoryImpl;
import ru.vsu.csf.service.DepartmentService;
import ru.vsu.csf.service.PatientService;

import java.util.Set;

public class DepartmentServiceImpl implements DepartmentService {
    private final DepartmentRepository departmentRepository;
    private final PatientRepository patientRepository;


    public DepartmentServiceImpl(Set<Department> departments, Set<Patient> patients) {
        departmentRepository = new DepartmentRepositoryImpl(departments);
        patientRepository  = new PatientRepositoryImpl(patients);
    }

    private int currId = 0;
    @Override
    public Department create(String name) {
        return new Department(currId++, name);
    }

    @Override
    public Department findByName(String name) {
        return departmentRepository.findByName(name);
    }

    @Override
    public Department findById(int id) {
        return departmentRepository.findById(id);
    }

    @Override
    public Department removeById(int id) {
        return departmentRepository.deleteById(id);
        //TODO: remove patients from department
    }

    @Override
    public Department removeByName(String name) {
        return departmentRepository.deleteByName(name);
    }

    @Override
    public Department updateById(int id, String name) {
        Department department = findById(id);
        department.setName(name);
        return department;
    }

    @Override
    public Department updateByName(String name, String newName) {
        Department department = findByName(name);
        department.setName(newName);
        return department;
    }

    @Override
    public void addPatient(int departmentId, int patientId) {
        Department department = departmentRepository.findById(departmentId);
        Patient patient = patientRepository.findById(patientId);
        if (department.getPatients().contains(patient)) {
            return;
        }
        patient.setDepartmentName(department.getName());
        department.getPatients().add(patient);
        department.setNumberOfPatients(department.getNumberOfPatients() + 1);
    }

    @Override
    public void removePatient(int departmentId, int patientId) {
        Department department = departmentRepository.findById(departmentId);
        Patient patient = patientRepository.findById(patientId);
        if (department.getPatients().contains(patient)) {
            department.getPatients().remove(patient);
            department.setNumberOfPatients(department.getNumberOfPatients() - 1);
            patient.setDepartmentName(null);
        }
        //TODO: Иначе может быть бросать ошибку или что то еще делать
    }

}
