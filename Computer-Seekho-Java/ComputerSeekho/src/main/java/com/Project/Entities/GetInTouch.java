package com.Project.Entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import lombok.Data;


@Entity
@Data
@Table(name = "get_in_touch")
public class GetInTouch {
    
    @Id
    @Column(name = "get_in_touch_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int getInTouchId;

    @Column(name = "enquirer_name")
    private String enquirerName;

    @Column(name = "enquirer_email")
    @NotBlank(message = "Email is required")
    @Email(message = "Email must be valid")
    private String email;

    @NotBlank(message = "Mobile number is required")
    @Pattern(regexp = "\\d{10}", message = "Mobile number must be 10 digits")
    @Column(name = "enquirer_mobile")
    private String mobile;

    @Column(name = "enquirer_message")
    private String enquiryMessage;
    
    @Column(name = "course_name")
    private String courseName;
}
