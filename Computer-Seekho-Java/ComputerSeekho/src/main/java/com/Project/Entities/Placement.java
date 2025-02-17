package com.Project.Entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Data
@Table(name = "placement")
public class Placement {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "placement_id")
    private int placementID;

    @OneToOne
    @JoinColumn(name = "student_id", referencedColumnName = "student_id")
    private Student studentID;

    @ManyToOne
    @JoinColumn(name = "recruiter_id", referencedColumnName = "recruiter_id")
    private Recruiter recruiterID;

    @ManyToOne
    @JoinColumn(name = "batch_id",referencedColumnName = "batch_id")
    private Batch batch;
}
