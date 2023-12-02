package ru.vsu.csf.repository.impl;

import ru.vsu.csf.database.ConnectionManager;
import ru.vsu.csf.enums.Sex;
import ru.vsu.csf.model.Department;
import ru.vsu.csf.model.Patient;
import ru.vsu.csf.repository.HospitalRepository;
import ru.vsu.csf.repository.PatientRepository;

import java.sql.ResultSet;
import java.util.HashSet;
import java.util.Set;

public class PatientRepositoryImpl implements PatientRepository {
//    private final Set<Patient> patients;

    private static PatientRepositoryImpl instance;

    private static ConnectionManager connectionManager;

    private static DepartmentRepositoryImpl departmentRepository;

    public static PatientRepositoryImpl getInstance() {
        if (instance == null) {
            instance = new PatientRepositoryImpl();
            departmentRepository = DepartmentRepositoryImpl.getInstance();
            connectionManager = ConnectionManager.getInstance();
        }

        return instance;
    }

//    private PatientRepositoryImpl(Set<Patient> patients) {
//        this.patients = patients;
//    }

    @Override
    public Patient findById(int id) {
        try {
            ResultSet rs = connectionManager.executeSelect("SELECT * FROM `patients` WHERE id = " + id);
            rs.next();
            Patient patient = getPatient(rs);
            rs.close();
            return patient;
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return null;
    }

    @Override
    public void create(Patient patient) {
        try {
            connectionManager.executeUpdate("INSERT INTO `patients`(`id`, `first_name`, `last_name`, `patronymic`, `age`, `sex`) VALUES ( "
                    + patient.getId() + ", '" + patient.getFirstName() + "', '" + patient.getLastName() + "', '" + patient.getPatronymic() + "', " + patient.getAge() + ", '" + patient.getSex() + "')");

            return;
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    private Patient getPatient(ResultSet rs) {
        try {
            int id = rs.getInt(1);
            String firstName = rs.getString(2);
            String lastName = rs.getString(3);
            String patronymic = rs.getString(4);
            int age = rs.getInt(5);
            Sex sex = Sex.valueOf(rs.getString(6));
            int departmentId = rs.getInt(7);
            Patient patient = new Patient(firstName, lastName, patronymic, age, sex);
            patient.setId(id);
            if (departmentId != 0) {
                patient.setDepartment(departmentRepository.findById(departmentId));
            }
            return patient;
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return null;
    }

    @Override
    public Patient deleteById(int id) {
        Patient patient = findById(id);
        try {
            connectionManager.executeUpdate("DELETE FROM `patients` WHERE id = " + id);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return patient;
    }

    @Override
    public Patient deleteByFullName(String firstName, String lastName, String patronymic) {
//        Patient patient = findByFullName(firstName, lastName, patronymic);
//        patients.remove(patient);
//        return patient;
        return null;
    }

    @Override
    public Set<Patient> findAll() {
        try{
            Set<Patient> patients = new HashSet<>();
            ResultSet rs = connectionManager.executeSelect("SELECT * FROM `patients`");
            while (!rs.isClosed() && rs.next()) {
                patients.add(getPatient(rs));
            }
            rs.close();
            return patients;
        } catch (Exception e){
            System.out.println(e.getMessage());
        }
        return null;
    }

    @Override
    public void update(int id, Patient patient) {
        try {
            connectionManager.executeUpdate("UPDATE `patients` SET `id`=" + id + "," +
                    "`first_name`='" + patient.getFirstName() + "',`last_name`='" + patient.getLastName() + "',`patronymic`='" + patient.getPatronymic() + "', `age`=" + patient.getAge() + ", `sex`='" + patient.getSex() + "' WHERE id = " + id);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    @Override
    public Patient findByFullName(String firstName, String lastName, String patronymic) {
//        for (Patient patient : patients) {
//            if (patient.getFirstName().equals(firstName) && patient.getLastName().equals(lastName) && patient.getPatronymic().equals(patronymic)) {
//                return patient;
//            }
//        }
        return null;
    }
}
