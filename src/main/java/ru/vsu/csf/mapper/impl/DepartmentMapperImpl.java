package ru.vsu.csf.mapper.impl;

import ru.vsu.csf.dto.DepartmentDto;
import ru.vsu.csf.mapper.DepartmentMapper;
import ru.vsu.csf.model.Department;

import java.util.HashSet;
import java.util.Set;

public class DepartmentMapperImpl implements DepartmentMapper {
    @Override
    public Department fromDto(DepartmentDto departmentDto) {
        Department department = new Department(departmentDto.getName());
        department.setNumberOfPatients(departmentDto.getNumberOfPatients());
        department.setPatients(departmentDto.getPatients());
        return department;
    }

    @Override
    public DepartmentDto toDto(Department department) {
        DepartmentDto departmentDto = new DepartmentDto(department.getId(), department.getName());
        departmentDto.setNumberOfPatients(department.getNumberOfPatients());
        departmentDto.setPatients(department.getPatients());
        return departmentDto;
    }

    @Override
    public Set<Department> fromDtoSet(Set<DepartmentDto> departmentDtos) {
        Set<Department> departments = new HashSet<>();
        for (DepartmentDto departmentDto : departmentDtos) {
            departments.add(fromDto(departmentDto));
        }
        return departments;
    }

    @Override
    public Set<DepartmentDto> toDtoSet(Set<Department> departments) {
        Set<DepartmentDto> departmentDtos = new HashSet<>();
        for (Department department : departments) {
            departmentDtos.add(toDto(department));
        }
        return departmentDtos;
    }
}
