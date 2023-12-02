package ru.vsu.csf.mapper.impl;

import ru.vsu.csf.dto.PatientDto;
import ru.vsu.csf.mapper.PatientMapper;
import ru.vsu.csf.model.Patient;

import java.util.HashSet;
import java.util.Set;

public class PatientMapperImpl implements PatientMapper {
    @Override
    public Patient fromDto(PatientDto patientDto) {
        Patient patient = new Patient(patientDto.getFirstName(), patientDto.getLastName(), patientDto.getPatronymic(),
                patientDto.getAge(), patientDto.getSex());
        patient.setDepartment(patientDto.getDepartment());
        return patient;
    }

    @Override
    public PatientDto toDto(Patient patient) {
        PatientDto patientDto = new PatientDto(patient.getId(), patient.getFirstName(), patient.getLastName(), patient.getPatronymic(),
                patient.getAge(), patient.getSex());
        patientDto.setDepartment(patient.getDepartment());
        return patientDto;
    }

    @Override
    public Set<Patient> fromDtoSet(Set<PatientDto> patientDtos) {
        Set<Patient> patients = new HashSet<>();
        for (PatientDto patientDto : patientDtos) {
            patients.add(fromDto(patientDto));
        }
        return patients;
    }

    @Override
    public Set<PatientDto> toDtoSet(Set<Patient> patients) {
        Set<PatientDto> patientDtos = new HashSet<>();
        for (Patient patient : patients) {
            patientDtos.add(toDto(patient));
        }
        return patientDtos;
    }
}
