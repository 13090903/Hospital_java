package ru.vsu.csf.service;

import java.util.Set;

public interface HospitalService<T> {
    T findById(int id);
    Set<T> findAll();
    T deleteById(int id);
}
