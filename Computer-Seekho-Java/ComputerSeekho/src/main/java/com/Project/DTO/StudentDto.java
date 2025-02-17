package com.Project.DTO;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class StudentDto {
    private int id;
    private String photoUrl;
    private String name; 
    private String mobile;
    private String course;
    private String batch;
    private int pendingFees;
}