package com.Project.Repositories;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import com.Project.Entities.Course;

import jakarta.transaction.Transactional;

@Repository
@Transactional
public interface CourseRepositories extends JpaRepository<Course, Integer> {
    @Query("select c from Course c where c.courseName = ?1")
    Optional<Course> findCourseByName(String courseName);
}
