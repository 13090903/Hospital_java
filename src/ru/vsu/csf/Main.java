package ru.vsu.csf;

import ru.vsu.csf.controller.DepartmentController;
import ru.vsu.csf.controller.PatientController;
import ru.vsu.csf.enums.Sex;
import ru.vsu.csf.model.Department;
import ru.vsu.csf.model.Patient;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class Main {
    private static PatientController patientController;
    private static DepartmentController departmentController;

    static Scanner in = new Scanner(System.in);

    static void showCommands() {
        System.out.println("""
                1 - создать пациента
                2 - создать отделение
                3 - показать пациентов
                4 - показать отделения
                5 - добавить пациента в отделение
                6 - удалить пациента из отделения
                7 - обновить название отделеня
                8 - обновить пациента
                9 - удалить отделение""");
    }

    static void createPatient(PatientController patientController) {
        System.out.println("Введите ФИО, возраст, пол в формате: Иванов Иван Иванович 18 М");
        String[] s = in.nextLine().split(" ");
        patientController.createPatient(s[0], s[1], s[2], Integer.parseInt(s[3]), s[4].equals("М") ? Sex.MALE : Sex.FEMALE);
    }

    static void createDepartment(DepartmentController departmentController) {
        System.out.println("Введите название отделения в формате: Хирургия");
        String[] s = in.nextLine().split(" ");
        departmentController.createDepartment(s[0]);
    }

    static void showDepartments(DepartmentController departmentController) {
        for (Department department : departmentController.showDepartments()) {
            System.out.println(department);
        }
    }

    static void showPatients(PatientController patientController) {
        for (Patient patient : patientController.showPatients()) {
            System.out.println(patient);
        }
    }

    static void addPatientToDepartment(DepartmentController departmentController) {
        System.out.println("Если хотите добавить пациента в отделение по его id, введите 1, если по названию, введите 2");
        String s = in.next();
        if (s.equals("1")) {
            System.out.println("Введите id отделения, затем id пациента в формате: 3 2");
            String s1 = in.next();
            String s2 = in.next();
            departmentController.addPatientByIds(Integer.parseInt(s1), Integer.parseInt(s2));
        } else if (s.equals("2")) {
            System.out.println("Введите название отделения, затем id пациента в формате: Хирургия 2");
            String s1 = in.next();
            String s2 = in.next();
            departmentController.addPatientByPatientId(s1, Integer.parseInt(s2));
        }
    }

    static void removePatientFromDepartment(DepartmentController departmentController) {
        System.out.println("Если хотите удалить пациента в отделение по его id, введите 1, если по названию, введите 2");
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
    }

    static void updateDepartmentName(DepartmentController departmentController) {
        System.out.println("Если хотите обновить название отделения по его id, введите 1, если по названию, введите 2");
        String s = in.next();
        if (s.equals("1")) {
            System.out.println("Введите id отделения, затем новое название в формате: 3 Хирургия");
            String s1 = in.next();
            String s2 = in.next();
            departmentController.updateDepartmentById(Integer.parseInt(s1), s2);
        } else if (s.equals("2")) {
            System.out.println("Введите название отделения, затем новое название в формате: Неврология Хирургия");
            String s1 = in.next();
            String s2 = in.next();
            departmentController.updateDepartmentByName(s1, s2);
        }
    }

    static void removeDepartment(DepartmentController departmentController) {
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
    }

    static void updatePatient(PatientController patientController) {
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
            String[] s2 = in.nextLine().split(" ");
            System.out.println("Введите новое значение выбранного поля");
            String s3 = in.next();
            switch (s) {
                case "1" -> patientController.updateFirstNameByFullName(s2[0], s2[1], s2[2], s3);
                case "2" -> patientController.updateLastNameByFullName(s2[0], s2[1], s2[2], s3);
                case "3" -> patientController.updatePatronymicByFullName(s2[0], s2[1], s2[2], s3);
                case "4" -> patientController.updateAgeByFullName(s2[0], s2[1], s2[2], Integer.parseInt(s3));
                case "5" -> patientController.updateSexByFullName(s2[0], s2[1], s2[2], s3.equals("М") ? Sex.MALE : Sex.FEMALE);
            }
        }
    }

    public static void main(String[] args) {
        Set<Patient> patients = new HashSet<>();
        Set<Department> departments = new HashSet<>();
        patientController = new PatientController(patients);
        departmentController = new DepartmentController(departments, patients);
        System.out.println("Чтобы начать, введите <s>. Чтобы завершить работу, введите <e>. Чтобы посмотреть команды, введите <c>");
        String command1 = in.next();
        switch (command1) {
            case "s" -> {
                while (true) {
                    String command = in.next();
                    switch (command) {
                        case "e" -> System.exit(0);
                        case "c" -> showCommands();
                        case "1" -> createPatient(patientController);
                        case "2" -> createDepartment(departmentController);
                        case "3" -> showPatients(patientController);
                        case "4" -> showDepartments(departmentController);
                        case "5" -> addPatientToDepartment(departmentController);
                        case "6" -> removePatientFromDepartment(departmentController);
                        case "7" -> updateDepartmentName(departmentController);
                        case "8" -> updatePatient(patientController);
                        case "9" -> removeDepartment(departmentController);
                    }
                }
            }
            case "e" -> System.exit(0);
            case "c" -> showCommands();
        }
    }
}