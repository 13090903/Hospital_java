package ru.vsu.csf.repository.impl;

import ru.vsu.csf.database.ConnectionManager;
import ru.vsu.csf.enums.Sex;
import ru.vsu.csf.model.Patient;
import ru.vsu.csf.repository.PatientRepository;

import java.sql.ResultSet;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class PatientRepositoryImpl implements PatientRepository {
//    private final Set<Patient> patients;

    private static PatientRepositoryImpl instance;

    private static ConnectionManager connectionManager;

    private static final Map<Integer, Integer> patientDepartmentMap = new HashMap<>();

    private static DepartmentRepositoryImpl departmentRepository;

    public static PatientRepositoryImpl getInstance() {
        if (instance == null) {
            instance = new PatientRepositoryImpl();
            departmentRepository = DepartmentRepositoryImpl.getInstance();
            connectionManager = ConnectionManager.getInstance();
        }

        return instance;
    }

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
                    + patient.getId() + ", '" + patient.getFirstName() + "', '"
                    + patient.getLastName() + "', '" + patient.getPatronymic()
                    + "', " + patient.getAge() + ", '" + patient.getSex() + "')");

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
            patientDepartmentMap.put(id, departmentId);
            return patient;
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return null;
    }

    @Override
    public void deleteById(int id) {
        try {
            connectionManager.executeUpdate("DELETE FROM `patients` WHERE id = " + id);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
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
            for (Patient patient : patients) {
                if (patientDepartmentMap.get(patient.getId()) != 0) {
                    patient.setDepartment(departmentRepository.findById(patientDepartmentMap.get(patient.getId())));
                }
            }
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
}
