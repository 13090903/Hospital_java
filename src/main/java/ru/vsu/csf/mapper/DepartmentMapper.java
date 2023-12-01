package ru.vsu.csf.mapper;

import ru.vsu.csf.dto.DepartmentDto;
import ru.vsu.csf.model.Department;

import java.util.Set;

public interface DepartmentMapper {
    Department fromDto(DepartmentDto departmentDto);
    DepartmentDto toDto(Department department);
    Set<Department> fromDtoSet(Set<DepartmentDto> departmentDtos);
    Set<DepartmentDto> toDtoSet(Set<Department> departments);
}
