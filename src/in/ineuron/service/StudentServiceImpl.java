package in.ineuron.service;
import in.ineuron.daofactory.StudentDAOFactory;
import in.ineuron.dto.Student;
import in.ineuron.persistence.IStudentDAO;
import in.ineuron.servicefactory.StudentServiceFactory;

/*
SERVICE LAYER LOGIC
In this we need DAO object to call the methods of persistence layer.

*/
public class StudentServiceImpl implements IStudentService{
    private IStudentDAO stdDAO;
    @Override
    public String addStudent(String name, Integer age, String city) {
        stdDAO = StudentDAOFactory.getStudentDAO();
        return stdDAO.addStudent(name, age, city);
    }

    @Override
    public Student searchStudent(Integer id) {
        stdDAO = StudentDAOFactory.getStudentDAO();
        return stdDAO.searchStudent(id);
    }

    @Override
    public String updateStudent(Student student) {
        stdDAO = StudentDAOFactory.getStudentDAO();
        return stdDAO.updateStudent(student);
    }

    @Override
    public String deleteStudent(Integer id) {
        stdDAO = StudentDAOFactory.getStudentDAO();

        return stdDAO.deleteStudent(id);
    }
}
