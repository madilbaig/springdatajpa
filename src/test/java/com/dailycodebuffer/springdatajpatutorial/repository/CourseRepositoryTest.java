package com.dailycodebuffer.springdatajpatutorial.repository;

import com.dailycodebuffer.springdatajpatutorial.entity.*;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class CourseRepositoryTest {
    @Autowired
    private CourseRepository courseRepository;

    @Test
    public void saveCourse(){
        Course course = Course.builder()
                .title("DAA")
                .credit(7)
                .build();

        courseRepository.save(course);
    }

    @Test
    public void printCourses(){
        List<Course> courses = courseRepository.findAll();
        System.out.println("Courses List : " + courses);
    }
    @Test
    public void saveCourseWithTeacher(){
        Teacher teacher = Teacher.builder()
                .firstName("Syed")
                .lastName("Mohiuddin")
                .build();
        Course course = Course.builder()
                .title("Python")
                .credit(4)
                .teacher(teacher)
                .build();
        courseRepository.save(course);
    }

    @Test
    public void saveCourseWithStudentAndTeacher(){
        Teacher teacher = Teacher.builder()
                .firstName("Gucci")
                .lastName("Zara")
                .build();
        Guardian guardian = Guardian.builder()
                .email("brand@gmail.com")
                .name("Brand")
                .mobile("9876543210")
                .build();
        Student student = Student.builder()
                .firstName("Gacci")
                .lastName("Zaara")
                .emailId("gaccizaara@gmail.com")
                .guardian(guardian)
                .build();
//        CourseMaterial courseMaterial = CourseMaterial.builder()
//                .url("www.guccizara.com")
//                .build();
        Course course = Course.builder()
                .title("Brands")
                .credit(12)
                .teacher(teacher)
                //.courseMaterial(courseMaterial)
                .build();
        course.addStudents(student);
        courseRepository.save(course);
    }
}