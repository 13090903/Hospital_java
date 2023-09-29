package ru.vsu.csf;

import ru.vsu.csf.controller.DepartmentController;
import ru.vsu.csf.controller.PatientController;
import ru.vsu.csf.enums.Sex;
import ru.vsu.csf.model.Department;
import ru.vsu.csf.model.Patient;

import java.util.HashSet;
import java.util.Set;

public class Main {
    private static PatientController patientController;
    private static DepartmentController departmentController;

    public static void main(String[] args) {
        Set<Patient> patients = new HashSet<>();
        Set<Department> departments = new HashSet<>();
        patientController = new PatientController(patients);
        departmentController = new DepartmentController(departments, patients);
        patientController.createPatient("Ivan", "Ivanov", "Petrovich", 18, Sex.MALE);
        patientController.createPatient("Petr", "Petrov", "Ivanovich", 17, Sex.MALE);
        patientController.createPatient("Nastya", "Ivanova", "Ivanovna", 17, Sex.FEMALE);
        patientController.showPatients();
        departmentController.createDepartment("Neurology");
        departmentController.createDepartment("Surgery");
        departmentController.showDepartments();
        departmentController.addPatientByIds(1, 0);
        departmentController.addPatientByIds(1, 1);
        departmentController.addPatientByIds(0, 2);
        departmentController.showDepartments();
        patientController.updateAgeById(0, 19);
        departmentController.removePatientByIds(1, 0);
        departmentController.showDepartments();
        patientController.showPatients();
        departmentController.removeDepartmentByName("Surgery");
        departmentController.showDepartments();
        patientController.showPatients();
    }
}