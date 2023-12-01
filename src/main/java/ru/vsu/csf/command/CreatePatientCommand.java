package ru.vsu.csf.command;

import ru.vsu.csf.controller.DepartmentController;
import ru.vsu.csf.controller.PatientController;
import ru.vsu.csf.enums.Sex;

import java.util.Scanner;

public class CreatePatientCommand implements Command{

    @Override
    public String execute(Scanner in, DepartmentController departmentController, PatientController patientController) {
        try {
            System.out.println("Введите ФИО, возраст, пол в формате: Иванов Иван Иванович 18 М");
            in.nextLine();
            String[] s = in.nextLine().split(" ");
            patientController.createPatient(s[1], s[0], s[2], Integer.parseInt(s[3]), s[4].equals("М") ? Sex.MALE : Sex.FEMALE);
            return  "Успешно!";
        } catch (Exception e) {
            throw new IllegalArgumentException("Ввод некорректен!");
        }
    }
}
