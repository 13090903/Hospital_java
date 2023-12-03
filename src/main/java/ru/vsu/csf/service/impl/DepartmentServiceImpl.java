package ru.vsu.csf.service.impl;

import ru.vsu.csf.model.Department;
import ru.vsu.csf.repository.DepartmentRepository;
import ru.vsu.csf.repository.impl.DepartmentRepositoryImpl;
import ru.vsu.csf.service.DepartmentService;

import java.util.Set;

public class DepartmentServiceImpl implements DepartmentService {
    private final DepartmentRepository departmentRepository;


    public DepartmentServiceImpl() {
        departmentRepository = DepartmentRepositoryImpl.getInstance();
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
        Set<Department> departments = departmentRepository.findAll();
        for (Department department : departments) {
            int count = departmentRepository.countNumberOfPatients(department.getId());
            department.setNumberOfPatients(count);
        }
        return departments;
    }

    @Override
    public void deleteById(int id) {
        departmentRepository.deleteById(id);
    }

    @Override
    public void updateById(int id, String name) {
        departmentRepository.update(id, new Department(name));
    }

    @Override
    public void addPatient(int departmentId, int patientId) {
        departmentRepository.addPatient(departmentId, patientId);
    }

    @Override
    public void removePatient(int departmentId, int patientId) {
        departmentRepository.removePatient(departmentId, patientId);
    }

}
