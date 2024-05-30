/*DAO stands for Data Access Object. DAO Design Pattern is used to separate the data persistence logic in a
separate layer. In DAO Layer we will write Persistence Layer Logic.
This way, the service remains completely in dark about how the low-level operations to access the database is done.
This is known as the principle of Separation of Logic.

*/

package in.ineuron.persistence;
import in.ineuron.dto.Student;

public interface IStudentDAO {
    //Operations to be implemented.
    String addStudent(String name, Integer age, String city);
    Student searchStudent(Integer id);
    String updateStudent(Student student);
    String deleteStudent(Integer id);
}
