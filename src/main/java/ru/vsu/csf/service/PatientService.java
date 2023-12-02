package ru.vsu.csf.service;

import ru.vsu.csf.enums.Sex;
import ru.vsu.csf.model.Patient;

public interface PatientService extends HospitalService<Patient>{

    void create(String firstName, String lastName, String patronymic, int age, Sex sex);
//    void findByFullName(String firstName, String lastName, String patronymic);
    void updateFirstName(int id, String firstName);
    void updateLastName(int id, String lastName);
    void updatePatronymic(int id, String patronymic);
    void updateAge(int id, int age);
    void updateSex(int id, Sex sex);
    Patient removeByFullName(String firstName, String lastName, String patronymic);
}
