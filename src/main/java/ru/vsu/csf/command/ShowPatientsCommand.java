package ru.vsu.csf.command;

import ru.vsu.csf.controller.DepartmentController;
import ru.vsu.csf.controller.PatientController;
import ru.vsu.csf.model.Patient;

import java.util.Scanner;

public class ShowPatientsCommand implements Command{

    @Override
    public String execute(Scanner in, DepartmentController departmentController, PatientController patientController) {
        if (patientController.showPatients().size() == 0) {
            return "Нет пациентов";
        }
        for (Patient patient : patientController.showPatients()) {
            System.out.println(patient);
        }
        return "Успешно";
    }
}
