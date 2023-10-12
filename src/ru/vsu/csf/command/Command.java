package ru.vsu.csf.command;

import ru.vsu.csf.controller.DepartmentController;
import ru.vsu.csf.controller.PatientController;

import java.util.Scanner;

public interface Command {
    public String execute(Scanner in, DepartmentController departmentController, PatientController patientController);
}
