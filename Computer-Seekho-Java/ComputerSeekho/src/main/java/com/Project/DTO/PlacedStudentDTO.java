package com.Project.DTO;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor

public class PlacedStudentDTO {
    private int batchId;
    private String batchName;
    private String studentName;
    private String photoUrl;
    private String recruiterName;
}
