package ru.vsu.csf.controller;

import ru.vsu.csf.model.Department;
import ru.vsu.csf.service.DepartmentService;
import ru.vsu.csf.service.impl.DepartmentServiceImpl;

import java.util.Set;

public class DepartmentController {
    private final DepartmentService departmentService;


    public DepartmentController() {
        departmentService = new DepartmentServiceImpl();
    }

    public void createDepartment(String name) {
        departmentService.create(name);
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
        departmentService.deleteById(id);
    }

    public void updateDepartmentById(int id, String name) {
        departmentService.updateById(id, name);
    }

    public Set<Department> showDepartments() {
        return departmentService.findAll();
    }
}
