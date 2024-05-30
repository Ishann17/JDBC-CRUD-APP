package in.ineuron.controller;

import in.ineuron.dto.Student;
import in.ineuron.service.IStudentService;
import in.ineuron.servicefactory.StudentServiceFactory;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;

//Controller Logic
public class TestApp {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        while(true){
            System.out.println("\nWelcome to CRUD App");
            System.out.println("Please select your choice : ");
            System.out.println("1 for Create");
            System.out.println("2 for Read");
            System.out.println("3 for Update");
            System.out.println("4 for Delete");
            System.out.println("5 to exit the app");
            int choice = sc.nextInt();

            switch (choice){
                case 1 -> insertOperation();
                case 2 -> searchOperation();
                case 3 -> updateOperation();
                case 4 -> deleteOperation();
                case 5 -> {
                    System.out.println("Thank you for using this Application.");
                    System.exit(0);
                }
                default -> System.out.println("Invalid Input Please choose a valid option.");
            }
        }
    }

    private static void updateOperation() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        System.out.print("Enter the student id : ");
        String id = br.readLine();
        IStudentService studentService = StudentServiceFactory.getStudentService();
        Student student = studentService.searchStudent(Integer.parseInt(id));
        if(student!=null){
            Student newStudent = new Student();
            System.out.println("Student id is : " + student.getId());
            newStudent.setId(student.getId());
            System.out.println("Student OLD Name is : " + student.getName() + " Enter the NEW name : ");
            String newName = br.readLine();
            if(newName.equals("")||newName == ""){
                newStudent.setName(student.getName());
            }else{
                newStudent.setName(newName);
            }
            System.out.println("Student OLD Age is : " + student.getAge() + " Enter the NEW age : ");
            String newAge = br.readLine();
            if(newAge.equals("")||newAge == ""){
                newStudent.setAge(student.getAge());
            }else{
                newStudent.setAge(Integer.parseInt(newAge));
            }
            System.out.println("Student OLD City is : " + student.getCity() + " Enter the NEW name : ");
            String newCity = br.readLine();
            if(newCity.equals("")||newCity == ""){
                newStudent.setCity(student.getCity());
            }else{
                newStudent.setCity(newCity);
            }
            String msg = studentService.updateStudent(newStudent);
            if(msg.equalsIgnoreCase("success")){
                System.out.println("Student Record successfully updated");
            } else  {
                System.out.println("Record Updation Failed");
            }


        }else {
            System.out.println("Student Record not available for the id " + id);
        }
    }

    private static void deleteOperation() {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter the student id : ");
        int id = sc.nextInt();
        IStudentService studentService = StudentServiceFactory.getStudentService();
        String msg = studentService.deleteStudent(id);
        if(msg.equalsIgnoreCase("success")){
            System.out.println("Student Record successfully deleted");
        } else if (msg.equalsIgnoreCase("not found")) {
            System.out.println("Record not available for the given id : " + id);
        } else{
            System.out.println("Record not deleted because id not found : " + id);
        }
    }

    private static void searchOperation() {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter the ID of the student : ");
        int id = sc.nextInt();
        IStudentService studentService = StudentServiceFactory.getStudentService();
        Student std = studentService.searchStudent(id);
        if(std != null){
            System.out.println(std);
            System.out.println("ID\tNAME\tAGE\tCITY");
            System.out.println(std.getId() + "\t" + std.getName() + "\t" + std.getAge() + "\t" + std.getCity());
        }
        else {
            System.out.println("Record not found for the give id : " + id);
        }
    }

    private static void insertOperation() {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter the name of the student : ");
        String name = sc.next();
        System.out.print("Enter the age of the student : ");
        int age = sc.nextInt();
        System.out.print("Enter the city of the student : ");
        String city = sc.next();

        IStudentService studentService = StudentServiceFactory.getStudentService();
        String msg = studentService.addStudent(name, age, city);
        if(msg.equalsIgnoreCase("success")){
            System.out.println("Records Inserted Successfully");
        }else {
            System.out.println("Records Not Inserted!");
        }
    }
}
