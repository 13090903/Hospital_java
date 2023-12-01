package ru.vsu.csf.repository;

import ru.vsu.csf.model.Department;

import java.util.Set;

public interface DepartmentRepository extends HospitalRepository<Department>{
    Department deleteByName(String name);
    Department findByName(String name);
}
