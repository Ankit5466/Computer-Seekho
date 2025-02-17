package com.Project.Controllers;

import java.time.LocalDateTime;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.Project.DTO.ApiResponse;
import com.Project.Entities.Course;
import com.Project.Services.CourseService;

@RestController
@RequestMapping("/course")
public class CourseController {
    @Autowired
    private CourseService courseService;

    @GetMapping("get/{id}")
    public ResponseEntity<Course> getCourseById(@PathVariable int id) {
        Course course = courseService.getCourseById(id).get();
        if(course == null) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(null);
        }
        return ResponseEntity.status(HttpStatus.CREATED).body(course);
    }
    @GetMapping("/getAll")
    public ResponseEntity<List<Course>> getAllCourses() {
        List<Course> courses = courseService.getAllCourses();
        System.out.println("Fetched courses: " + courses);
        return ResponseEntity.ok(courses);
    }
    

    @PostMapping("/add")
    public ResponseEntity<ApiResponse> addCourse(@RequestBody Course course) {
        courseService.addCourse(course);
        // if(course2 == null) {
        //     return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(new ApiResponse("internal ", null));
        // }
        return ResponseEntity.status(HttpStatus.CREATED).body(new ApiResponse("Course added sucessfully", LocalDateTime.now()));
    }
    @PutMapping("/update")
    public ResponseEntity<Course> updateCourse(@RequestBody Course course) {
        Course course2 = courseService.updateCourse(course, course.getCourseId());
        if(course2 == null) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(null);
        }
        return ResponseEntity.status(HttpStatus.CREATED).body(course2);
    }
    @DeleteMapping("/delete/{courseId}")
    public ResponseEntity<ApiResponse> deleteCourse(@PathVariable int courseId) {
        courseService.deleteCourse(courseId);
        return new ResponseEntity<>(new ApiResponse("Course Deleted", LocalDateTime.now()), HttpStatus.OK);
    }

    @GetMapping("/find/{courseName}")
    public ResponseEntity<Course> findCourseByName(@PathVariable String courseName) {
        Course course = courseService.findCourseByName(courseName).get();
        if(course == null) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(null);
        }
        return ResponseEntity.status(HttpStatus.CREATED).body(course);
    }

}
