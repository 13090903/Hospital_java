package ru.vsu.csf.repository.impl;

import ru.vsu.csf.model.Department;
import ru.vsu.csf.repository.DepartmentRepository;
import ru.vsu.csf.repository.HospitalRepository;

import java.util.Set;

public class DepartmentRepositoryImpl implements DepartmentRepository {
    private final Set<Department> departments;
    private static DepartmentRepositoryImpl instance;
    public static DepartmentRepositoryImpl getInstance(Set<Department> departments) {
        if (instance == null)
            instance = new DepartmentRepositoryImpl(departments);

        return instance;
    }

    private DepartmentRepositoryImpl(Set<Department> departments) {
        this.departments = departments;
    }

    @Override
    public Department findById(int id) {
        for (Department department : departments) {
            if (department.getId() == id) {
                return department;
            }
        }
        return null;
    }

    @Override
    public Department deleteById(int id) {
        Department department = findById(id);
        departments.remove(department);
        return department;
    }

    @Override
    public Department deleteByName(String name) {
        Department department = findByName(name);
        departments.remove(department);
        return department;
    }

    @Override
    public Department findByName(String name) {
        for (Department department : departments) {
            if (department.getName().equals(name)) {
                return department;
            }
        }
        return null;
    }

    @Override
    public Set<Department> findAll() {
        return departments;
    }
}
