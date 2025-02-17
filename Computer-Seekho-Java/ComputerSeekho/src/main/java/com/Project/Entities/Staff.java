package com.Project.Entities;

import com.fasterxml.jackson.annotation.JsonProperty;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.Data;

@Entity
@Data
@Table (name = "staff")
public class Staff {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "staff_id")
    private int staffId;

    @Column(name = "staff_name")
    @NotBlank(message = "Staff name is mandatory")
    private String staffName;

    @Column(name = "photo_url")
    @NotBlank(message = "photoUrl is mandatory")
    private String photoUrl;

    @Column(name = "staff_email")
    @NotBlank(message = "Email is required")
    @Email(message = "Email must be valid")
    private String staffEmail;

    @Column(name = "staff_mobile")
    @NotBlank(message = "Mobile number is required")
    @Pattern(regexp = "\\d{10}", message = "Mobile number must be 10 digits")
    private String staffMobile;

    @Column(name = "staff_gender")
    @NotBlank(message = "Select Gender")
    private String staffGender;

    @Column(name = "staff_username")
    @NotBlank(message = "Username is required")
    @Size(min = 5, max = 30, message = "Username must be between 5 and 30 characters")
    private String staffUsername;

    @Column(name = "staffPassword")
    @NotBlank(message = "Password is required")
    @Size(min = 8, message = "Password must be at least 8 characters")
    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    private String staffPassword;

    @Column(name = "staff_role")
    private String staffRole;
}
