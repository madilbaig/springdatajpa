package com.dailycodebuffer.springdatajpatutorial.repository;

import com.dailycodebuffer.springdatajpatutorial.entity.Course;
import com.dailycodebuffer.springdatajpatutorial.entity.Teacher;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class TeacherRepositoryTest {

    @Autowired
    private TeacherRepository teacherRepository;

    @Test
    public void saveTeacher(){
        Course course = Course.builder()
                .title("SBJ")
                .credit(7)
                .build();

        Course coursejava = Course.builder()
                .title("Java")
                .credit(6)
                .build();

        Teacher teacher = Teacher.builder()
                //.courses(List.of(course, coursejava))
                .firstName("Shabbir")
                .lastName("Dawoodi")
                .build();
        teacherRepository.save(teacher);
    }

    @Test
    public void printTeacher(){
        List<Teacher> teachers = teacherRepository.findAll();
        System.out.println("Teachers list: " + teachers);
    }

}