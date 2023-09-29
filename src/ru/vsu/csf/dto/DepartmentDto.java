package ru.vsu.csf.dto;

import ru.vsu.csf.model.Patient;

import java.util.Set;

public class DepartmentDto {
    private int id;
    private String name;
    private int numberOfPatients;
    private Set<Patient> patients;

    public DepartmentDto(int id, String name) {
        this.id = id;
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getNumberOfPatients() {
        return numberOfPatients;
    }

    public void setNumberOfPatients(int numberOfPatients) {
        this.numberOfPatients = numberOfPatients;
    }

    public Set<Patient> getPatients() {
        return patients;
    }

    public void setPatients(Set<Patient> patients) {
        this.patients = patients;
    }

    @Override
    public String toString() {
        return "DepartmentDto{" +
                "name='" + name + '\'' +
                ", numberOfPatients=" + numberOfPatients +
                '}';
    }
}
