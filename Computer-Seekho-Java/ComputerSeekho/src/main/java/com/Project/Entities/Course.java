package com.Project.Entities;

import jakarta.persistence.*;
import lombok.Data;

@Table(name = "course")
@Entity
@Data
public class Course {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "course_id")
    private int courseId;

    @Column(length = 100, name = "course_name") 
    private String courseName;

    @Column(length = 500, name = "course_descriptor") 
    private String courseDescription;

    @Column(name = "course_duration")
    private int courseDuration;

    @Column(length = 200, name = "course_syllabus") 
    private String courseSyllabus;

    @Column(name = "course_fee")
    private double courseFee;

    @Column(name = "course_is_active")
    private boolean courseIsActive =  true;

    @Column(length = 100, name = "cover_photo") 
    private String coverPhoto;
    
    
}