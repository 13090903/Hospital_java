package ru.vsu.csf.repository;

import ru.vsu.csf.model.Department;

import java.util.Set;

public interface HospitalRepository<T> {
    T findById(int id);
    T deleteById(int id);
    Set<T> findAll();
}
