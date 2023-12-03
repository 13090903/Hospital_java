package ru.vsu.csf.controller;

import ru.vsu.csf.enums.Sex;
import ru.vsu.csf.model.Patient;
import ru.vsu.csf.service.PatientService;
import ru.vsu.csf.service.impl.PatientServiceImpl;

import java.util.Set;

public class PatientController {
    private final PatientService patientService;


    public PatientController() {
        this.patientService = new PatientServiceImpl();
    }

    public void createPatient(String firstName, String lastName, String patronymic, int age, Sex sex) {
        patientService.create(firstName, lastName, patronymic, age, sex);
    }
    public void removePatientById(int id) {
        patientService.deleteById(id);
    }

    public void updateFirstNameById(int id, String firstName) {
        patientService.updateFirstName(id, firstName);
    }

    public void updateLastNameById(int id, String lastName) {
        patientService.updateLastName(id, lastName);
    }

    public void updatePatronymicById(int id, String patronymic) {
        patientService.updatePatronymic(id, patronymic);
    }

    public void updateAgeById(int id, int age) {
        patientService.updateAge(id, age);
    }

    public void updateSexById(int id, Sex sex) {
        patientService.updateSex(id, sex);
    }

    public Set<Patient> showPatients() {
        return patientService.findAll();
    }
}
