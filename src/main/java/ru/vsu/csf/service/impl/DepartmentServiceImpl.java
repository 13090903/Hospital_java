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


    public DepartmentServiceImpl() {
        departmentRepository = DepartmentRepositoryImpl.getInstance();
        patientRepository  = PatientRepositoryImpl.getInstance();
    }

    @Override
    public void create(String name) {
        departmentRepository.create(new Department(name));
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
    public Set<Department> findAll() {
        return departmentRepository.findAll();
    }

    @Override
    public Department deleteById(int id) {
        return departmentRepository.deleteById(id);
    }

    @Override
    public Department removeByName(String name) {
//        for (Patient patient : patientRepository.findAll()) {
//            Department d = patient.getDepartment();
//            if (d != null && d.getName().equals(name)) {
//                patient.setDepartment(null);
//            }
//        }
//        return departmentRepository.deleteByName(name);
        return null;
    }

    @Override
    public void updateById(int id, String name) {
        departmentRepository.update(id, new Department(name));
    }

    @Override
    public Department updateByName(String name, String newName) {
//        Department department = findByName(name);
//        department.setName(newName);
//        return department;
        return null;
    }

    @Override
    public void addPatient(int departmentId, int patientId) {
        Department department = departmentRepository.findById(departmentId);
        Patient patient = patientRepository.findById(patientId);
        if (department.getPatients().contains(patient)) {
            return;
        }
        patient.setDepartment(department);
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
            patient.setDepartment(null);
        }
    }

}
