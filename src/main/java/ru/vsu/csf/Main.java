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
            new ShowPatientsCommand(),
            new ShowDepartmentsCommand(),
            new AddPatientToDepartmentCommand(),
            new RemovePatientFromDepartmentCommand(),
            new UpdateDepartmentCommand(),
            new UpdatePatientCommand(),
            new DeleteDepartmentCommand(),
            new DeletePatientCommand()
    };


    public static void main(String[] args) {
        Set<Patient> patients = new HashSet<>();
        Set<Department> departments = new HashSet<>();
        PatientController patientController = new PatientController(patients);
        DepartmentController departmentController = new DepartmentController(departments, patients);
        System.out.println("""
                1 - создать пациента
                2 - создать отделение
                3 - показать пациентов
                4 - показать отделения
                5 - добавить пациента в отделение
                6 - удалить пациента из отделения
                7 - обновить название отделеня
                8 - обновить пациента
                9 - удалить отделение
                10 - удалить пациента""");
        while (true) {
            System.out.println("Введите номер команды ");
            int i = in.nextInt();
            System.out.println(commands[i - 1].execute(in, departmentController, patientController));
        }
    }
}