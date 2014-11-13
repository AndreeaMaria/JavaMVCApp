package ro.z2h.Controller;

import ro.z2h.annotation.MyController;
import ro.z2h.annotation.MyRequestMethod;
import ro.z2h.domain.Employee;
import ro.z2h.service.EmployeeServiceImpl;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;

/**
 * Created by Maria on 11/11/2014.
 */
@MyController(urlPath = "/employee")

public class EmployeeController {
    @MyRequestMethod(urlPath = "/all")
   public List<Employee> getAllEmployees(){

        /*List<Employee> listaangajati = new ArrayList<Employee>();
        Employee employee1 = new Employee();
        employee1.setId(1l);
        Employee employee2 = new Employee();
        employee2.setId(2l);
        listaangajati.add(employee1);
        listaangajati.add(employee2);*/
        EmployeeServiceImpl objEmployee = new EmployeeServiceImpl();

        return objEmployee.findAllEmployees();



    }

    @MyRequestMethod(urlPath = "/one")
    public Employee getOneEmployee(){
        Employee employee = new Employee();
     EmployeeServiceImpl objEmployeeOne = new EmployeeServiceImpl();
     objEmployeeOne.findOneEmployee(100l);
        return objEmployeeOne.findOneEmployee(100l);
    }
}
