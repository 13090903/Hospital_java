package ru.vsu.csf.repository.impl;

import ru.vsu.csf.database.ConnectionManager;
import ru.vsu.csf.model.Department;
import ru.vsu.csf.repository.DepartmentRepository;

import java.sql.ResultSet;
import java.util.HashSet;
import java.util.Set;

public class DepartmentRepositoryImpl implements DepartmentRepository {
    private static DepartmentRepositoryImpl instance;
    private static ConnectionManager connectionManager;

    public static DepartmentRepositoryImpl getInstance() {
        if (instance == null) {
            instance = new DepartmentRepositoryImpl();
            connectionManager = ConnectionManager.getInstance();
        }

        return instance;
    }

    @Override
    public Department findById(int id) {
        try {
            ResultSet rs = connectionManager.executeSelect("SELECT * FROM `departments` WHERE id = " + id);
            rs.next();
            Department department = getDepartment(rs);
            rs.close();
            return department;
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return null;
    }

    private Department getDepartment(ResultSet rs) {
        try {
            int id = rs.getInt(1);
            String name = rs.getString(2);
            Department department = new Department(name);
            department.setId(id);
            return department;
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return null;
    }

    @Override
    public void deleteById(int id) {
        try {
            connectionManager.executeUpdate("DELETE FROM `departments` WHERE id = " + id);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    @Override
    public Department findByName(String name) {
        try {
            ResultSet rs = connectionManager.executeSelect("SELECT * FROM `departments` WHERE name = '" + name + "'");
            rs.next();
            Department department = getDepartment(rs);
            rs.close();
            return department;
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return null;
    }

    @Override
    public int countNumberOfPatients(int id) {
        try {
            ResultSet rs = connectionManager.executeSelect("SELECT COUNT(*) FROM `patients` WHERE department_id = " + id);
            rs.next();
            int count = rs.getInt(1);
            rs.close();
            return count;
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return 0;
    }

    @Override
    public void addPatient(int departmentId, int patientId) {
        try {
            connectionManager.executeUpdate("UPDATE `patients` SET `department_id`=" + departmentId + " WHERE id = " + patientId);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    @Override
    public void removePatient(int departmentId, int patientId) {
        try {
            connectionManager.executeUpdate("UPDATE `patients` SET `department_id`=" + null + " WHERE id = " + patientId);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    @Override
    public void create(Department department) {
        try {
            connectionManager.executeUpdate("INSERT INTO `departments`(`id`, `name`) VALUES ( "
                    + department.getId() + ", '" + department.getName() + "')");
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    @Override
    public Set<Department> findAll() {
        try {
            Set<Department> departments = new HashSet<>();
            ResultSet rs = connectionManager.executeSelect("SELECT * FROM `departments`");
            while (!rs.isClosed() && rs.next()) {
                departments.add(getDepartment(rs));
            }
            rs.close();
            return departments;
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return null;
    }

    @Override
    public void update(int id, Department department) {
        try {
            connectionManager.executeUpdate("UPDATE `departments` SET `id`=" + id + "," +
                    "`name`='" + department.getName() + "' WHERE id = " + id);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }


}
