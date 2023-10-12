package ru.vsu.csf.command;

import ru.vsu.csf.controller.DepartmentController;
import ru.vsu.csf.controller.PatientController;

import java.util.Scanner;

public class DeleteDepartmentCommand implements Command{

    @Override
    public String execute(Scanner in, DepartmentController departmentController, PatientController patientController) {
        try {
            System.out.println("Если хотите удалить отделение по его id, введите 1, если по названию, введите 2");
            String s = in.next();
            if (s.equals("1")) {
                System.out.println("Введите id отделения в формате: 3");
                String s1 = in.next();
                departmentController.removeDepartmentById(Integer.parseInt(s1));
            } else if (s.equals("2")) {
                System.out.println("Введите название отделения в формате: Хирургия");
                String s1 = in.next();
                departmentController.removeDepartmentByName(s1);
            }
            return "Успешно!";
        } catch (Exception e) {
            throw new IllegalArgumentException("Ввод некорректен!");
        }
    }
}
