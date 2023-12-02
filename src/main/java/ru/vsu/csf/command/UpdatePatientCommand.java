package ru.vsu.csf.command;

import ru.vsu.csf.controller.DepartmentController;
import ru.vsu.csf.controller.PatientController;
import ru.vsu.csf.enums.Sex;

import java.util.Scanner;

public class UpdatePatientCommand implements Command {

    @Override
    public String execute(Scanner in, DepartmentController departmentController, PatientController patientController) {
        try {
            System.out.println("Если хотите обновить имя введите 1, если фамилию, введите 2, отчество - 3, возраст - 4, пол - 5");
            String s = in.next();
            System.out.println("Введите id пациента в формате: 3");
            String s2 = in.next();
            System.out.println("Введите новое значение выбранного поля");
            String s3 = in.next();
            switch (s) {
                case "1" -> patientController.updateFirstNameById(Integer.parseInt(s2), s3);
                case "2" -> patientController.updateLastNameById(Integer.parseInt(s2), s3);
                case "3" -> patientController.updatePatronymicById(Integer.parseInt(s2), s3);
                case "4" -> patientController.updateAgeById(Integer.parseInt(s2), Integer.parseInt(s3));
                case "5" ->
                        patientController.updateSexById(Integer.parseInt(s2), s3.equals("М") ? Sex.MALE : Sex.FEMALE);
            }
            return "Успешно!";
        } catch (Exception e) {
            throw new IllegalArgumentException("Ввод некорректен!");
        }
    }
}
