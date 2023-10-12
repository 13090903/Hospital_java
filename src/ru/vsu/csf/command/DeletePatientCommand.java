package ru.vsu.csf.command;

import ru.vsu.csf.controller.DepartmentController;
import ru.vsu.csf.controller.PatientController;

import java.util.Scanner;

public class DeletePatientCommand implements Command{

    @Override
    public String execute(Scanner in, DepartmentController departmentController, PatientController patientController) {
        try {
            System.out.println("Если хотите удалить пациента по его id, введите 1, если по полному имени, введите 2");
            String s = in.next();
            if (s.equals("1")) {
                System.out.println("Введите id пациента в формате: 3");
                String s1 = in.next();
                patientController.removePatientById(Integer.parseInt(s1));
            } else if (s.equals("2")) {
                System.out.println("Введите полное имя пациента в формате: Иванов Иван Иванович");
                String[] s1 = in.nextLine().split(" ");
                patientController.removePatientByFullName(s1[1], s1[0], s1[2]);
            }
            return "Успешно!";
        } catch (Exception e) {
            throw new IllegalArgumentException("Ввод некорректен!");
        }
    }
}
