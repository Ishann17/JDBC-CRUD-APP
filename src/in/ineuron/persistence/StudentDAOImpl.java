package in.ineuron.persistence;

import in.ineuron.dto.Student;
import in.ineuron.util.JDBCUtil;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

//Persistence Logic using JDBC API
public class StudentDAOImpl implements IStudentDAO{
    Connection connection = null;
    PreparedStatement preparedStatement = null;
    ResultSet resultSet = null;
    @Override
    public String addStudent(String name, Integer age, String city) {
        String query = "INSERT INTO students (name, age, city) VALUES(?,?,?)";
        try {
            connection = JDBCUtil.getJDBCConnection();
            if(connection != null){
              preparedStatement = connection.prepareStatement(query);
              preparedStatement.setString(1, name);
              preparedStatement.setInt(2, age);
              preparedStatement.setString(3, city);

              //Execute the query
                int rowsAffected = preparedStatement.executeUpdate();
                if(rowsAffected >= 1){
                    return "success";
                }
            }
        } catch (SQLException | IOException e) {
            System.out.println("Failed to Establish Connection in StudentDAOImpl");
            e.printStackTrace();
        }
        return "failure";
    }

    @Override
    public Student searchStudent(Integer id) {
        String query = "SELECT id, name, age, city FROM students WHERE id = ?";
        Student student = null;
        try {
            connection = JDBCUtil.getJDBCConnection();
            if (connection != null) {
                preparedStatement = connection.prepareStatement(query);
                preparedStatement.setInt(1, id);
                //Execute the query
                resultSet = preparedStatement.executeQuery();
                if (resultSet != null) {
                    if (resultSet.next()) {
                        //Since ResultSet is not serializable we have to copy it from RS to Student object using setters.
                        student = new Student();
                        student.setId(resultSet.getInt(1));
                        student.setName(resultSet.getString(2));
                        student.setAge(resultSet.getInt(3));
                        student.setCity(resultSet.getString(4));
                        return student;
                    }
                }
            }
        } catch (SQLException | IOException e) {
            System.out.println("Failed to Establish Connection in StudentDAOImpl");
            e.printStackTrace();
        }
        return student;
    }

    @Override
    public String updateStudent(Student student) {
        String query = "UPDATE students SET name=?, age=?, city=? WHERE id = ?";
        try {
            connection = JDBCUtil.getJDBCConnection();
            if(connection != null){
                preparedStatement = connection.prepareStatement(query);
                preparedStatement.setString(1, student.getName());
                preparedStatement.setInt(2, student.getAge());
                preparedStatement.setString(3, student.getCity());
                preparedStatement.setInt(4, student.getId());
                //Execute the query
                int rowsAffected = preparedStatement.executeUpdate();
                if(rowsAffected >= 1){
                    return "success";
                }
            }
        } catch (SQLException | IOException e) {
            System.out.println("Failed to Establish Connection in StudentDAOImpl");
            e.printStackTrace();
        }
        return "failure";
    }

    @Override
    public String deleteStudent(Integer id) {
        String query = "DELETE FROM students WHERE id = ?";
        try{
            connection = JDBCUtil.getJDBCConnection();
            if(connection!=null)
                preparedStatement = connection.prepareStatement(query);
            if(preparedStatement != null){
                preparedStatement.setInt(1, id);
                int rows = preparedStatement.executeUpdate();
                if(rows == 1){
                    return "success";
                }else {
                    return "not found";
                }
            }

        }catch (SQLException | IOException e){
            e.printStackTrace();
        }
        return "failure";
    }
}
