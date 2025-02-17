package com.Project.Repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.Project.Entities.Student;

import jakarta.transaction.Transactional;

@Repository
public interface StudentRepositories extends JpaRepository<Student, Integer> {
    @Query(value = """
    SELECT s.student_id,s.photo_url,s.student_address,s.student_dob,
    s.student_gender,s.student_mobile,s.student_name,s.student_password,
    s.student_qualification,s.student_username,s.batch_id,s.course_id 
    FROM Student s 
    WHERE s.course_id = ?1"""
    ,nativeQuery = true)
    List<Student> findbycourse(int course_id);

    @Query(value = """
    SELECT s.student_id,s.photo_url,s.student_address,s.student_dob,
    s.student_gender,s.student_mobile,s.student_name,s.student_email,
    s.student_qualification,s.batch_id,s.course_id, s.payments_due
    FROM Student s 
    WHERE s.batch_id = ?1"""
    ,nativeQuery = true)
    List<Student> findByBatchId(int batchId);


    @Modifying
    @Transactional
    @Query(value="""
            update Student s set s.payment_due = (select c.course_fee from Course c where c.course_id = s.course_id) where s.student_id = ?1
            """, nativeQuery = true)
    void updatePayment(int StudentId);

    // @Query(value = """
    // DELETE FROM student WHERE student_id = ?1"""
    // ,nativeQuery = true)
    // int deleteStudent(int studentId);
}
