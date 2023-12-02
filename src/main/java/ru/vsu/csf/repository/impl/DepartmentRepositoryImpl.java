package ru.vsu.csf.repository.impl;

import ru.vsu.csf.database.ConnectionManager;
import ru.vsu.csf.model.Department;
import ru.vsu.csf.repository.DepartmentRepository;

import java.sql.ResultSet;
import java.util.HashSet;
import java.util.Set;

public class DepartmentRepositoryImpl implements DepartmentRepository {
//    private final Set<Department> departments;
    private static DepartmentRepositoryImpl instance;
    private static ConnectionManager connectionManager;
    public static DepartmentRepositoryImpl getInstance() {
        if (instance == null) {
            instance = new DepartmentRepositoryImpl();
            connectionManager = ConnectionManager.getInstance();
        }

        return instance;
    }

//    private DepartmentRepositoryImpl(Set<Department> departments) {
//        this.departments = departments;
//    }

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
            int numberOfPatients = rs.getInt(3);
            Department department = new Department(name);
            department.setId(id);
            department.setNumberOfPatients(numberOfPatients);
            return department;
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return null;
    }

    @Override
    public Department deleteById(int id) {
        Department department = findById(id);
        try {
            connectionManager.executeUpdate("DELETE FROM `departments` WHERE id = " + id);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return department;
    }

    @Override
    public Department deleteByName(String name) {
//        Department department = findByName(name);
//        departments.remove(department);
//        return department;
        return null;
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
    public void create(Department department) {
        try {
            connectionManager.executeUpdate("INSERT INTO `departments`(`id`, `name`) VALUES ( "
                    + department.getId() + ", '" + department.getName() + "')");
            return;
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    @Override
    public Set<Department> findAll() {
        try{
            Set<Department> departments = new HashSet<>();
            ResultSet rs = connectionManager.executeSelect("SELECT * FROM `departments`");
            while (!rs.isClosed() && rs.next()) {
                departments.add(getDepartment(rs));
            }
            rs.close();
            return departments;
        } catch (Exception e){
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
