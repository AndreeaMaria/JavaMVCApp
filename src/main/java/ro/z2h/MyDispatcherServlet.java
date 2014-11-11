package ro.z2h;

import ro.z2h.Controller.DepartmentController;
import ro.z2h.Controller.EmployeeController;
import ro.z2h.annotation.MyController;
import ro.z2h.annotation.MyRequestMethod;
import ro.z2h.domain.Department;
import ro.z2h.fmk.AnnotationScanUtils;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.lang.annotation.Annotation;
import java.lang.reflect.Method;

/**
 * Created by Maria on 11/11/2014.
 */
public class MyDispatcherServlet extends HttpServlet{



    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        /*Delegate to someone(App controller)*/
        dispatchReply("POST",req,resp);
    }



    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        /*Delegate to someone(App controller)*/
        dispatchReply("GET",req,resp);

    }

    private void dispatchReply(String httpMethod, HttpServletRequest req, HttpServletResponse resp) {
        /*Dispatch - delegare catre un app controller si asteprarea unui raspuns*/
       Object r = dispatch(req, resp);

        /*Transmiterea raspunsului catre client*/
        try {
            reply(r, req, resp);
        } catch (IOException e) {
            /*Transmitere eroare*/
            sendException(e, req, resp);

        }

    }

    private void sendException(Exception ex, HttpServletRequest req, HttpServletResponse resp) {

    }

    private void reply(Object r, HttpServletRequest req, HttpServletResponse resp)throws IOException{
        PrintWriter out = resp.getWriter();
        out.printf(r.toString());
    }

       /*Unde ar trebui apelat un app controller*/

    private Object dispatch(HttpServletRequest req, HttpServletResponse resp) {
        String pathInfo = req.getPathInfo();
        /*Stabilire controller in functia pathInfo*/
        if (pathInfo.startsWith("/employee")){
            EmployeeController controller = new EmployeeController();
            return controller.getAllEmployees();}
            else if(pathInfo.startsWith("/department")){
            DepartmentController controller = new DepartmentController();
            return controller.getAllDepartments();

        }
        return "Hello!";
    }

    @Override
    public void init() throws ServletException {
        try {
            Iterable<Class> classes = AnnotationScanUtils.getClasses("ro.z2h.Controller");
            for (Class aClass : classes) {
                System.out.println(aClass.getName());
                /*Daca poate fi controller*/
                if( aClass.isAnnotationPresent(MyController.class)){
                  MyController ctrlAnnotation= (MyController)aClass.getAnnotation(MyController.class);
                     /*Ce request path poate procesa*/
                    System.out.println(ctrlAnnotation.urlPath());

                    /*ex 19. Identificare metode care proceseaza business*/
                    Method[] methods = aClass.getMethods();
                    for (Method method : methods){
                       if( method.isAnnotationPresent(MyRequestMethod.class)){
                           MyRequestMethod methodAnnotation =(MyRequestMethod) method.getAnnotation(MyRequestMethod.class);
                           System.out.println(methodAnnotation.urlPath() + " " + methodAnnotation.methodType());
                       }
                    }
                }

            }
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


}
