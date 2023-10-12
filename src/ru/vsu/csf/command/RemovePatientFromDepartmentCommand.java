package ru.vsu.csf.command;

import ru.vsu.csf.controller.DepartmentController;
import ru.vsu.csf.controller.PatientController;

import java.util.Scanner;

public class RemovePatientFromDepartmentCommand implements Command{

    @Override
    public String execute(Scanner in, DepartmentController departmentController, PatientController patientController) {
        try {
            System.out.println("Если хотите удалить пациента из отделения по его id, введите 1, если по названию, введите 2");
            String s = in.next();
            if (s.equals("1")) {
                System.out.println("Введите id отделения, затем id пациента в формате: 3 2");
                String s1 = in.next();
                String s2 = in.next();
                departmentController.removePatientByIds(Integer.parseInt(s1), Integer.parseInt(s2));
            } else if (s.equals("2")) {
                System.out.println("Введите название отделения, затем id пациента в формате: Хирургия 2");
                String s1 = in.next();
                String s2 = in.next();
                departmentController.removePatientByPatientId(s1, Integer.parseInt(s2));
            }
            return "Успешно!";
        }  catch (Exception e) {
            throw new IllegalArgumentException("Ввод некорректен!");
        }
    }
}
