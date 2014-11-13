package ro.z2h.service;

import ro.z2h.dao.EmployeeDao;
import ro.z2h.domain.Employee;
import ro.z2h.utils.DatabaseManager;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Maria on 11/12/2014.
 */
public class EmployeeServiceImpl implements EmployeeService {
    @Override
    public List<Employee> findAllEmployees() {
        Connection connection = DatabaseManager.getConnection("ZTH_18", "passw0rd");
        EmployeeDao employeeDao = new EmployeeDao();
        ArrayList<Employee> allEmployees = new ArrayList<Employee>();
        try {
            allEmployees = employeeDao.getAllEmployees(connection);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return allEmployees;

    }

    @Override
    public Employee findOneEmployee(Long idEmployee) {
        Connection connection = DatabaseManager.getConnection("ZTH_18", "passw0rd");
        EmployeeDao employeeDao = new EmployeeDao();
        Employee oneEmployee = new Employee();
        try {
            oneEmployee = employeeDao.getEmployeeById(connection, idEmployee);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return oneEmployee;
    }

    @Override
    public void deleteOneEmployee(Long idEmployee) {
        Connection connection = DatabaseManager.getConnection("ZTH_18", "passw0ord");
        EmployeeDao deleteOneEmployee = new EmployeeDao();

    }
}
