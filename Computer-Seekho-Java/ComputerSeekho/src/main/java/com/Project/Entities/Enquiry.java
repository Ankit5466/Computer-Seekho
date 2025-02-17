package com.Project.Entities;

import java.time.LocalDate;
import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(name = "enquiry")
@Data
public class Enquiry {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "enquiry_id")
    private int enquiryId;

    @Column(name = "enquirer_name")
    private String enquirerName;

    @Column(name = "enquirer_address")
    private String enquirerAddress;

    @Column(name = "enquirer_mobile")
    private String enquirerMobile;

    @Column(name = "enquirer_email_id")
    private String enquirerEmailId;

    @Column(name = "enquiry_date")
    private LocalDate enquiryDate;

    @Column(name = "enquirer_query")
    private String enquirerQuery;

    @Column(name = "course_name")
    private String courseName;

    @ManyToOne
    @JoinColumn(name = "staff_id")
    private Staff staff;

    @Column(name = "student_name")
    private String studentName;

    @Column(name = "enquiry_counter")
    private int enquiryCounter;

    @Column(name = "closure_reason")
    private String closureReason;

    @Column(name = "follow_up_date")
    private LocalDate followUpDate;

    @Column(name = "enquiry_is_active", columnDefinition = "BOOLEAN DEFAULT TRUE")
    private boolean enquiryIsActive = true;

}