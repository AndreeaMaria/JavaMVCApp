package ro.z2h.service;

import ro.z2h.dao.DepartmentDao;
import ro.z2h.domain.Department;
import ro.z2h.utils.DatabaseManager;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Maria on 11/13/2014.
 */
public class DepartmentServiceImpl implements DeparmentService {

public List<Department>findAllDepartments(){
    Connection connection = DatabaseManager.getConnection("ZTH_18", "passw0rd");
    DepartmentDao departmentDao = new DepartmentDao();
    ArrayList<Department> allDepartments = new ArrayList<Department>();

    try {
        allDepartments = DepartmentDao.getAllDepartments(connection);
    } catch (SQLException e) {
        e.printStackTrace();
    }
    return allDepartments;
}



}
