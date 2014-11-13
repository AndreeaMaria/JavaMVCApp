package ro.z2h.Controller;

import ro.z2h.annotation.MyController;
import ro.z2h.annotation.MyRequestMethod;
import ro.z2h.domain.Department;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Maria on 11/11/2014.
 */
@MyController(urlPath = "/department")
public class DepartmentController {

    @MyRequestMethod(urlPath = "/all")
    public List<Department> getAllDepartments(){
        List<Department> listadep = new ArrayList<Department>();
        Department departments = new Department();
        listadep.add(departments);
        return listadep;
    }
    @MyRequestMethod(urlPath = "/one")
    public Department getOneDepartment() {
        Department department = new Department();
        return department;


    }
}
