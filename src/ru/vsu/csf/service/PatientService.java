package ru.vsu.csf.service;

import ru.vsu.csf.enums.Sex;
import ru.vsu.csf.model.Patient;

public interface PatientService extends HospitalService<Patient>{

    Patient create(String firstName, String lastName, String patronymic, int age, Sex sex);
    Patient findByFullName(String firstName, String lastName, String patronymic);
    Patient updateFirstName(int id, String firstName);
    Patient updateLastName(int id, String lastName);
    Patient updatePatronymic(int id, String patronymic);
    Patient updateAge(int id, int age);
    Patient updateSex(int id, Sex sex);
    Patient removeByFullName(String firstName, String lastName, String patronymic);
}
