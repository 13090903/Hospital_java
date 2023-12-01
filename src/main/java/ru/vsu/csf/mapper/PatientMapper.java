package ru.vsu.csf.mapper;

import ru.vsu.csf.dto.PatientDto;
import ru.vsu.csf.model.Patient;

import java.util.Set;

public interface PatientMapper {
    Patient fromDto(PatientDto patientDto);
    PatientDto toDto(Patient patient);
    Set<Patient> fromDtoSet(Set<PatientDto> patientDtos);
    Set<PatientDto> toDtoSet(Set<Patient> patients);
}
