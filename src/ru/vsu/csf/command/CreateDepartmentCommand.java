package ru.vsu.csf.command;

import ru.vsu.csf.controller.DepartmentController;
import ru.vsu.csf.controller.PatientController;

import java.util.Scanner;

public class CreateDepartmentCommand implements Command{

    @Override
    public String execute(Scanner in, DepartmentController departmentController, PatientController patientController) {
        try {
            System.out.println("Введите название отделения в формате: Хирургия");
            String[] s = in.next().split(" ");
            departmentController.createDepartment(s[0]);
            return  "Успешно!";
        } catch (Exception e) {
            throw new IllegalArgumentException("Ввод некорректен!");
        }
    }
}
