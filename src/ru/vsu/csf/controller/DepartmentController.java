package ru.vsu.csf.controller;

import ru.vsu.csf.model.Department;
import ru.vsu.csf.model.Patient;
import ru.vsu.csf.service.DepartmentService;
import ru.vsu.csf.service.impl.DepartmentServiceImpl;

import java.util.Set;

public class DepartmentController {
    private final Set<Department> departments;
    private final DepartmentService departmentService;


    public DepartmentController(Set<Department> departments, Set<Patient> patients) {
        this.departments = departments;
        departmentService = new DepartmentServiceImpl(departments, patients);
    }

    public void createDepartment(String name) {
        Department department = departmentService.create(name);
        departments.add(department);
    }

    public void addPatientByIds(int departmentId, int patientId) {
        departmentService.addPatient(departmentId, patientId);
    }

    public void removePatientByIds(int departmentId, int patientId) {
        departmentService.removePatient(departmentId, patientId);
    }

    public void addPatientByPatientId(String departmentName, int patientId) {
        departmentService.addPatient(departmentService.findByName(departmentName).getId(), patientId);
    }

    public void removePatientByPatientId(String departmentName, int patientId) {
        departmentService.removePatient(departmentService.findByName(departmentName).getId(), patientId);
    }

    public void removeDepartmentById(int id) {
        departmentService.removeById(id);
    }

    public void removeDepartmentByName(String name) {
        departmentService.removeByName(name);
    }

    public void showDepartments() {
        for (Department department : departments) {
            System.out.println(department);
        }
    }
}
