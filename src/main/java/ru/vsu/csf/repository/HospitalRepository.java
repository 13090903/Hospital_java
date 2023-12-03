package ru.vsu.csf.repository;

import ru.vsu.csf.model.Department;

import java.util.Set;

public interface HospitalRepository<T> {
    T findById(int id);
    void create(T object);
    void deleteById(int id);
    Set<T> findAll();
    void update(int id, T object);

}
