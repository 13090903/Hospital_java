package ru.vsu.csf.command;

import ru.vsu.csf.controller.DepartmentController;
import ru.vsu.csf.controller.PatientController;
import ru.vsu.csf.enums.Sex;

import java.util.Scanner;

public class UpdatePatientCommand implements Command{

    @Override
    public String execute(Scanner in, DepartmentController departmentController, PatientController patientController) {
        try {
            System.out.println("Если хотите обновить это по id пациента, введите 1, если по полному имени, введите 2");
            String s1 = in.next();
            System.out.println("Если хотите обновить имя введите 1, если фамилию, введите 2, отчество - 3, возраст - 4, пол - 5");
            String s = in.next();
            if (s1.equals("1")) {
                System.out.println("Введите id пациента в формате: 3");
                String s2 = in.next();
                System.out.println("Введите новое значение выбранного поля");
                String s3 = in.next();
                switch (s) {
                    case "1" -> patientController.updateFirstNameById(Integer.parseInt(s2), s3);
                    case "2" -> patientController.updateLastNameById(Integer.parseInt(s2), s3);
                    case "3" -> patientController.updatePatronymicById(Integer.parseInt(s2), s3);
                    case "4" -> patientController.updateAgeById(Integer.parseInt(s2), Integer.parseInt(s3));
                    case "5" -> patientController.updateSexById(Integer.parseInt(s2), s3.equals("М") ? Sex.MALE : Sex.FEMALE);
                }
            } else if (s1.equals("2")) {
                System.out.println("Введите полное имя пациента в формате: Иванов Иван Иванович");
                in.nextLine();
                String[] s2 = in.nextLine().split(" ");
                System.out.println("Введите новое значение выбранного поля");
                String s3 = in.next();
                switch (s) {
                    case "1" -> patientController.updateFirstNameByFullName(s2[1], s2[0], s2[2], s3);
                    case "2" -> patientController.updateLastNameByFullName(s2[1], s2[0], s2[2], s3);
                    case "3" -> patientController.updatePatronymicByFullName(s2[1], s2[0], s2[2], s3);
                    case "4" -> patientController.updateAgeByFullName(s2[1], s2[0], s2[2], Integer.parseInt(s3));
                    case "5" -> patientController.updateSexByFullName(s2[1], s2[0], s2[2], s3.equals("М") ? Sex.MALE : Sex.FEMALE);
                }
            }
            return "Успешно!";
        } catch (Exception e) {
            throw new IllegalArgumentException("Ввод некорректен!");
        }
    }
}
