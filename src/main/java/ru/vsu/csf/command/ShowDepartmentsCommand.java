package ru.vsu.csf.command;

import ru.vsu.csf.controller.DepartmentController;
import ru.vsu.csf.controller.PatientController;
import ru.vsu.csf.model.Department;

import java.util.Scanner;

public class ShowDepartmentsCommand implements Command {

    @Override
    public String execute(Scanner in, DepartmentController departmentController, PatientController patientController) {
        if (departmentController.showDepartments().size() == 0) {
            return "Нет отделений";
        }
        for (Department department : departmentController.showDepartments()) {
            System.out.println(department);
        }
        return "Успешно";
    }
}
