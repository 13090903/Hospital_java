package ru.vsu.csf;

import ru.vsu.csf.command.*;
import ru.vsu.csf.controller.DepartmentController;
import ru.vsu.csf.controller.PatientController;
import ru.vsu.csf.enums.Sex;
import ru.vsu.csf.model.Department;
import ru.vsu.csf.model.Patient;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class Main {

    static Scanner in = new Scanner(System.in);
    static Command[] commands = new Command[]{
            new CreatePatientCommand(),
            new CreateDepartmentCommand(),
            new AddPatientToDepartmentCommand(),
            new ShowPatientsCommand(),
            new ShowDepartmentsCommand()
    };


    public static void main(String[] args) {
        Set<Patient> patients = new HashSet<>();
        Set<Department> departments = new HashSet<>();
        PatientController patientController = new PatientController(patients);
        DepartmentController departmentController = new DepartmentController(departments, patients);
        for (Command command : commands) {
            System.out.println(command.execute(in, departmentController, patientController));
        }
    }
}