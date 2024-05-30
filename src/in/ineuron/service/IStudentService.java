package in.ineuron.service;

import in.ineuron.dto.Student;

public interface IStudentService {
    //Operations to be Implemented.
    String addStudent(String name, Integer age, String city);
    Student searchStudent(Integer id);
    String updateStudent(Student student);
    String deleteStudent(Integer id);
}
