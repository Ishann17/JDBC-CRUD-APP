package in.ineuron.daofactory;

import in.ineuron.persistence.IStudentDAO;
import in.ineuron.persistence.StudentDAOImpl;

public class StudentDAOFactory {
    private static IStudentDAO studentDAO = null;
    private  StudentDAOFactory(){

    }
    public static IStudentDAO getStudentDAO(){
        if(studentDAO == null){
            studentDAO = new StudentDAOImpl();
        }
        return studentDAO;
    }
}
