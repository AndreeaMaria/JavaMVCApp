package ro.z2h.Controller;

import ro.z2h.annotation.MyController;
import ro.z2h.annotation.MyRequestMethod;

/**
 * Created by Maria on 11/11/2014.
 */
@MyController(urlPath = "/department")
public class DepartmentController {
    @MyRequestMethod(urlPath = "/all")
    public String getAllDepartments(){
        return "allDepartments";
    }
    @MyRequestMethod(urlPath = "/one")
    public String getOneDepartment(){
        return "Department";

    }
}
