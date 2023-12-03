package ru.vsu.csf.command;

import ru.vsu.csf.controller.DepartmentController;
import ru.vsu.csf.controller.PatientController;

import java.util.Scanner;

public class DeleteDepartmentCommand implements Command {

    @Override
    public String execute(Scanner in, DepartmentController departmentController, PatientController patientController) {
        try {
            System.out.println("Введите id отделения в формате: 3");
            String s1 = in.next();
            departmentController.removeDepartmentById(Integer.parseInt(s1));
            return "Успешно!";
        } catch (Exception e) {
            throw new IllegalArgumentException("Ввод некорректен!");
        }
    }
}
