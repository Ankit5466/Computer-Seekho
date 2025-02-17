package com.Project.Services;

import java.util.List;
import java.util.Optional;

import com.Project.DTO.StudentDto;
import com.Project.Entities.Student;

public interface StudentService {
    Optional<Student> getStudentById(int studentId);
    List<StudentDto> getAllStudents();
    Student addStudent(Student student,int enquiryId);
    Student updateStudent(Student student,int studentId);
    void deleteStudent(int studentId);
    List<Student> getbybatch(int batchId);
    List<Student> getbycourse(int courseId);

}
