package com.dailycodebuffer.springdatajpatutorial.repository;

import com.dailycodebuffer.springdatajpatutorial.entity.Guardian;
import com.dailycodebuffer.springdatajpatutorial.entity.Student;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class StudentRepositoryTest {

    @Autowired
    private StudentRepository studentRepository;

    @Test
    public void saveStudent(){
        Student student = Student.builder()
                .emailId("adil@gmail.com")
                .firstName("Adil")
                .lastName("Baig")
//                .guardianName("Ghar")
//                .guardianEmail("ghar@gamil.com")
//                .guardianMobile("9090909090")
                .build();

        studentRepository.save(student);
    }

    @Test
    public void saveStudentWithGuardian(){
        Guardian guardian = Guardian.builder()
                .email("ghar@gmail.com")
                .name("Ghar")
                .mobile("9090909090")
                .build();

        Student student = Student.builder()
                .emailId("arfath@gmail.com")
                .firstName("Arfath")
                .lastName("Baig")
                .guardian(guardian)
                .build();

        studentRepository.save(student);
    }

    @Test
    public void printAllStudents(){
        List<Student> studentList = studentRepository.findAll();
        System.out.println("Student List = " + studentList);
    }

    @Test
    public void printStudentByFirstName(){
        List<Student> studentList = studentRepository.findByFirstName("Adil");
        System.out.println("Student List with Adil as their first name is " + studentList);
    }

    @Test
    public void printStudentByFirstNameContaining(){
        List<Student> studentList = studentRepository.findByFirstNameContaining("dil");
        System.out.println("Student List containing dil in their first name is " + studentList);
    }

    @Test
    public void printStudentByLastName(){
        List<Student> studentList = studentRepository.findByLastName("Baig");
        System.out.println("Student List with Baig as their last name is " + studentList);
    }

    @Test
    public void printStudentByLastNameContaining(){
        List<Student> studentList = studentRepository.findByLastNameContaining("Ba");
        System.out.println("Student List containing Ba in their last name is " + studentList);
    }

    @Test
    public void printStudentByLastNameNotNull(){
        List<Student> studentList = studentRepository.findByLastNameNotNull();
        System.out.println("Student List without last name is " + studentList);
    }

    @Test
    public void printStudentByEmailId(){
        Student student = studentRepository.findByEmailId("adil@gmail.com");
        System.out.println("Student with adil@gmail.com as their email id is " + student);
    }

    @Test
    public void printStudentByEmailIdContaining(){
        List<Student> studentList = studentRepository.findByEmailIdContaining("dil");
        System.out.println("Student List containing dil in their first name is " + studentList);
    }

    @Test
    public void printStudentByGuardianName(){
        List<Student> studentList = studentRepository.findByGuardianName("Ghar");
        System.out.println("Student List with Ghar as their guardian name is " + studentList);
    }

    @Test
    public void printStudentByGuardianEmail(){
        List<Student> studentList = studentRepository.findByGuardianEmail("ghar@gmail.com");
        System.out.println("Student List with Ghar@gmail.com as their guardian Mail is " + studentList);
    }

    @Test
    public void printStudentByGuardianMobile(){
        List<Student> studentList = studentRepository.findByGuardianMobile("9090909090");
        System.out.println("Student List with 9090909090 as their guardian mobile is " + studentList);
    }

    @Test
    public void printStudentByEmailAddress(){
        Student student = studentRepository.getStudentByEmailId("adil@gmail.com");
        System.out.println("Student with adil@gmail.com as their email id is " + student);
    }

    @Test
    public void printStudentFirstNameByEmailAddress(){
        String firstNameByEmailId = studentRepository.getStudentFirstNameByEmailId("adil@gmail.com");
        System.out.println("Student with adil@gmail.com as their email id is " + firstNameByEmailId);
    }

    @Test
    public void printStudentByEmailIdNative(){
        Student student = studentRepository.getStudentByEmailId("adil@gmail.com");
        System.out.println("Student with adil@gmail.com as their email id is " + student);
    }

}