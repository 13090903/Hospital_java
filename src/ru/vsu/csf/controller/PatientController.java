package ru.vsu.csf.controller;

import ru.vsu.csf.enums.Sex;
import ru.vsu.csf.model.Patient;
import ru.vsu.csf.service.PatientService;
import ru.vsu.csf.service.impl.PatientServiceImpl;

import java.util.Set;

public class PatientController {
    protected Set<Patient> patients;
    private final PatientService patientService;


    public PatientController(Set<Patient> patients) {
        this.patients = patients;
        this.patientService = new PatientServiceImpl(patients);
    }

    public void createPatient(String firstName, String lastName, String patronymic, int age, Sex sex) {
        Patient patient = patientService.create(firstName, lastName, patronymic, age, sex);
        patients.add(patient);
    }

    public void removePatientByFullName(String firstName, String lastName, String patronymic) {
        Patient patient = patientService.removeByFullName(firstName, lastName, patronymic);
    }
    public void removePatientById(int id) {
        Patient patient = patientService.removeById(id);
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

    public void updateFirstNameByFullName(String firstName, String lastName, String patronymic, String newFirstName) {
        patientService.updateFirstName(patientService.findByFullName(firstName, lastName, patronymic).getId(), newFirstName);
    }

    public void updateLastNameByFullName(String firstName, String lastName, String patronymic, String newLastName) {
        patientService.updateLastName(patientService.findByFullName(firstName, lastName, patronymic).getId(), newLastName);
    }

    public void updatePatronymicByFullName(String firstName, String lastName, String patronymic, String newPatronymic) {
        patientService.updatePatronymic(patientService.findByFullName(firstName, lastName, patronymic).getId(), newPatronymic);
    }

    public void updateAgeByFullName(String firstName, String lastName, String patronymic, int age) {
        patientService.updateAge(patientService.findByFullName(firstName, lastName, patronymic).getId(), age);
    }

    public void updateSexByFullName(String firstName, String lastName, String patronymic, Sex sex) {
        patientService.updateSex(patientService.findByFullName(firstName, lastName, patronymic).getId(), sex);
    }


    public Set<Patient> showPatients() {
        return patients;
    }
}
