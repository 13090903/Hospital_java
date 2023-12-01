package ru.vsu.csf.service;

public interface HospitalService<T> {
    T findById(int id);
    T deleteById(int id);
}
