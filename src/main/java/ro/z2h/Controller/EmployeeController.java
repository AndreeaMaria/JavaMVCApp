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

    EmployeeServiceImpl objEmployee = new EmployeeServiceImpl();

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
    public Employee getOneEmployee(String id){
     EmployeeServiceImpl objEmployeeOne = new EmployeeServiceImpl();
     return objEmployeeOne.findOneEmployee(Long.valueOf(id));


        }
    @MyRequestMethod(urlPath = "/delete")
    public void deleteOneEmployee(String id) {
        objEmployee.deleteOneEmployee(Long.valueOf(id)); }

    }



