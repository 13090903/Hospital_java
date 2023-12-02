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


    public PatientServiceImpl() {
        patientRepository = PatientRepositoryImpl.getInstance();
    }

    @Override
    public void create(String firstName, String lastName, String patronymic, int age, Sex sex) {
        patientRepository.create(new Patient(firstName, lastName, patronymic, age, sex));
    }

//    @Override
//    public Patient findByFullName(String firstName, String lastName, String patronymic) {
//        return patientRepository.findByFullName(firstName, lastName, patronymic);
//    }

    @Override
    public Patient findById(int id) {
        return patientRepository.findById(id);
    }

    @Override
    public Set<Patient> findAll() {
        return patientRepository.findAll();
    }

    @Override
    public void updateFirstName(int patientId, String firstName) {
        Patient patient = patientRepository.findById(patientId);
        patient.setFirstName(firstName);
        patientRepository.update(patientId, patient);
    }

    @Override
    public void updateLastName(int patientId, String lastName) {
        Patient patient = patientRepository.findById(patientId);
        patient.setLastName(lastName);
        patientRepository.update(patientId, patient);
    }

    @Override
    public void updatePatronymic(int patientId, String patronymic) {
        Patient patient = patientRepository.findById(patientId);
        patient.setPatronymic(patronymic);
        patientRepository.update(patientId, patient);
    }

    @Override
    public void updateAge(int patientId, int age) {
        Patient patient = patientRepository.findById(patientId);
        patient.setAge(age);
        patientRepository.update(patientId, patient);
    }

    @Override
    public void updateSex(int patientId, Sex sex) {
        Patient patient = patientRepository.findById(patientId);
        patient.setSex(sex);
        patientRepository.update(patientId, patient);
    }


    @Override
    public Patient deleteById(int id) {
        Patient patient = patientRepository.findById(id);
        Department department = patient.getDepartment();
        if (department != null && department.getPatients().contains(patient)) {
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
