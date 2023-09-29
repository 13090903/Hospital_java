package ru.vsu.csf.repository;

import ru.vsu.csf.model.Department;

import java.util.Set;

public interface DepartmentRepository {
    Department findById(int id);
    Department deleteById(int id);
    Department deleteByName(String name);
    Department findByName(String name);
    Set<Department> findByAll();
}
