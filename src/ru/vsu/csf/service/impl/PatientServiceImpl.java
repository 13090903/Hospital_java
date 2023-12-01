package ru.vsu.csf.service.impl;

import ru.vsu.csf.dto.PatientDto;
import ru.vsu.csf.enums.Sex;
import ru.vsu.csf.mapper.PatientMapper;
import ru.vsu.csf.mapper.impl.PatientMapperImpl;
import ru.vsu.csf.model.Department;
import ru.vsu.csf.model.Patient;
import ru.vsu.csf.repository.DepartmentRepository;
import ru.vsu.csf.repository.PatientRepository;
import ru.vsu.csf.repository.impl.DepartmentRepositoryImpl;
import ru.vsu.csf.repository.impl.PatientRepositoryImpl;
import ru.vsu.csf.service.PatientService;

import java.util.Set;

public class PatientServiceImpl implements PatientService {
    private final PatientRepository patientRepository;


    public PatientServiceImpl(Set<Patient> patients) {
        patientRepository = PatientRepositoryImpl.getInstance(patients);
    }
    private int currId = 0;

    @Override
    public Patient create(String firstName, String lastName, String patronymic, int age, Sex sex) {
        return new Patient(currId++, firstName, lastName, patronymic, age, sex);
    }

    @Override
    public Patient findByFullName(String firstName, String lastName, String patronymic) {
        return patientRepository.findByFullName(firstName, lastName, patronymic);
    }

    @Override
    public Patient findById(int id) {
        return patientRepository.findById(id);
    }

    @Override
    public Patient updateFirstName(int patientId, String firstName) {
        Patient patient = patientRepository.findById(patientId);
        patient.setFirstName(firstName);
        return patient;
    }

    @Override
    public Patient updateLastName(int patientId, String lastName) {
        Patient patient = patientRepository.findById(patientId);
        patient.setLastName(lastName);
        return patient;
    }

    @Override
    public Patient updatePatronymic(int patientId, String patronymic) {
        Patient patient = patientRepository.findById(patientId);
        patient.setPatronymic(patronymic);
        return patient;
    }

    @Override
    public Patient updateAge(int patientId, int age) {
        Patient patient = patientRepository.findById(patientId);
        patient.setAge(age);
        return patient;
    }

    @Override
    public Patient updateSex(int patientId, Sex sex) {
        Patient patient = patientRepository.findById(patientId);
        patient.setSex(sex);
        return patient;
    }


    @Override
    public Patient deleteById(int id) {
        Patient patient = patientRepository.findById(id);
        Department department = patient.getDepartment();
        if (department.getPatients().contains(patient)) {
            department.getPatients().remove(patient);
            department.setNumberOfPatients(department.getNumberOfPatients() - 1);
            patient.setDepartment(null);
        }
        return patientRepository.deleteById(id);
    }

    @Override
    public Patient removeByFullName(String firstName, String lastName, String patronymic) {
        Patient patient = patientRepository.findByFullName(firstName, lastName, patronymic);
        Department department = patient.getDepartment();
        if (department.getPatients().contains(patient)) {
            department.getPatients().remove(patient);
            department.setNumberOfPatients(department.getNumberOfPatients() - 1);
            patient.setDepartment(null);
        }
        return patientRepository.deleteByFullName(firstName, lastName, patronymic);
    }

}
