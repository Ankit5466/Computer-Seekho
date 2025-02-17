package com.Project.Services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.Project.Entities.Course;
import com.Project.Repositories.CourseRepositories;

@Service
public class CourseServiceImpl implements CourseService {

    @Autowired
    private CourseRepositories courseRepositories;
  
    @Override
    public Optional<Course> getCourseById(int courseId) {
        return courseRepositories.findById(courseId);
    }

    @Override
    public List<Course> getAllCourses() {
        return courseRepositories.findAll();
    }

    @Override
    public Course addCourse(Course course) {
        return courseRepositories.save(course);
    }

    @Override
    public Course updateCourse(Course course, int courseId) {
        course.setCourseId(courseId);
        return courseRepositories.save(course);
    }

    @Override
    public void deleteCourse(int courseId) {
        courseRepositories.deleteById(courseId);
    }
    
    @Override
    public Optional<Course> findCourseByName(String courseName) {
        return courseRepositories.findCourseByName(courseName);
    }
}
