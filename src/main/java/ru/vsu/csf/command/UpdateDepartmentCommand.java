package ru.vsu.csf.command;

import ru.vsu.csf.controller.DepartmentController;
import ru.vsu.csf.controller.PatientController;

import java.util.Scanner;

public class UpdateDepartmentCommand implements Command {

    @Override
    public String execute(Scanner in, DepartmentController departmentController, PatientController patientController) {
        try {
            System.out.println("Введите id отделения, затем новое название в формате: 3 Хирургия");
            String s1 = in.next();
            String s2 = in.next();
            departmentController.updateDepartmentById(Integer.parseInt(s1), s2);
            return "Успешно!";
        } catch (Exception e) {
            throw new IllegalArgumentException("Ввод некорректен!");
        }
    }
}
