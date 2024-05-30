package in.ineuron.servicefactory;

import in.ineuron.service.IStudentService;
import in.ineuron.service.StudentServiceImpl;

//Abstraction Logic of Implementation
//Using Singleton Pattern
public class StudentServiceFactory {
    private static IStudentService studentService = null;
    private StudentServiceFactory(){
        //To avoid object creation of this class
    }
    public static IStudentService getStudentService(){
        if(studentService == null){
            studentService = new StudentServiceImpl();
        }
        return studentService;
    }
}
