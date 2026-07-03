package com.danztee.cruddemo;

import com.danztee.cruddemo.dao.StudentDAO;
import com.danztee.cruddemo.entity.Student;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.List;

@SpringBootApplication
public class CruddemoApplication {

    public static void main(String[] args) {
        SpringApplication.run(CruddemoApplication.class, args);
    }

    @Bean
    public CommandLineRunner commandLineRunner(StudentDAO studentDAO) {
        return runner -> {
//            createStudent(studentDAO);

            createMultipleStudents(studentDAO);

//            readStudent(studentDAO);

//            queryForStudents(studentDAO);

//            queryForStudentsByLastName(studentDAO);

//            updateStudent(studentDAO);

//            deleteStudent(studentDAO);

//            deleteAllStudents(studentDAO);


        };
    }

    private void deleteAllStudents(StudentDAO studentDAO) {
        System.out.println("Deleting all students with id");
        int numRowsDeleted = studentDAO.deleteAll();

        System.out.println("Deleted row count " + numRowsDeleted);

    }

    private void deleteStudent(StudentDAO studentDAO) {
        //        retrieve student based on the id: pk
        int studentId = 3;
        System.out.println("Deleting student with id: " + studentId);


//        Delete
        studentDAO.delete(studentId);
    }

    private void updateStudent(StudentDAO studentDAO) {
//        retrieve student based on the id: pk
        int studentId = 1;

        System.out.println("Getting student with id: " + studentId);
        Student myStudent = studentDAO.findById(studentId);

//        change first name
        System.out.println("Updating student...");
        myStudent.setFirstName("Danztee");

//        update the student
        studentDAO.update(myStudent);

//        display the updated student

        System.out.println("Updated student: " + myStudent);
    }

    private void queryForStudentsByLastName(StudentDAO studentDAO) {
//        get a list of students

        List<Student> theStudents = studentDAO.findByLastName("Doe");


//        display list of students

        for (Student tempStudents : theStudents) {
            System.out.println("the students: " + tempStudents);
        }

    }

    private void queryForStudents(StudentDAO studentDAO) {
        List<Student> theStudents = studentDAO.findAll();

        for (Student tempStudents : theStudents) {
            System.out.println("the students: " + tempStudents);
        }
    }

    private void readStudent(StudentDAO studentDAO) {

        int theId = this.createStudent(studentDAO);

        Student myStudent = studentDAO.findById(theId);

        System.out.println("Found the student: " + myStudent);


    }

    private void createMultipleStudents(StudentDAO studentDAO) {
//        create multiple students
        System.out.println("Creating 3 student object...");
        Student tempStudent1 = new Student("Femi", "Mary", "femi@gmail.com");
        Student tempStudent2 = new Student("Titi", "Kemi", "tit@gmail.com");
        Student tempStudent3 = new Student("Tife", "Brown", "brown@gmail.com");

        //        save the student object
        System.out.println("Saving the students...");
        studentDAO.save(tempStudent1);
        studentDAO.save(tempStudent2);
        studentDAO.save(tempStudent3);
    }

    private int createStudent(StudentDAO studentDAO) {
//        create the student object
        System.out.println("Creating new student object...");
        Student tempStudent = new Student("John", "Doe", "john@gmail.com");

//        save the student object
        System.out.println("Saving the student...");
        studentDAO.save(tempStudent);

//        display the id of the saved student
        System.out.println("Saved student. Generated id: " + tempStudent.getId());


        return tempStudent.getId();

    }

}
