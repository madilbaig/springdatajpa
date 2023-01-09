package com.dailycodebuffer.springdatajpatutorial.repository;

import com.dailycodebuffer.springdatajpatutorial.entity.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface StudentRepository extends JpaRepository<Student,Long> {

    public List<Student> findByFirstName(String firstName);
    public List<Student> findByFirstNameContaining(String name);
    public List<Student> findByLastName(String lastName);
    public List<Student> findByLastNameContaining(String name);
    public List<Student> findByLastNameNotNull();
    public Student findByEmailId(String emailId);
    public List<Student> findByEmailIdContaining(String name);
    public List<Student> findByGuardianName(String guardianName);
    public List<Student> findByGuardianEmail(String guardianName);
    public List<Student> findByGuardianMobile(String guardianName);

    //JPQL
//    @Query("Select s from Student s where s.emailId = ?1")
//    Student getStudentByEmailId(String emailId);

    //JPQL
    @Query("Select s.firstName from Student s where s.emailId = ?1")
    String getStudentFirstNameByEmailId(String emailId);

    //JPQL
    @Query(
            name = "SELECT * FROM student_tbl s where s.email_address = :emailId",
            nativeQuery = true
    )
    public Student getStudentByEmailId(@Param("emailId") String emailId);

}
