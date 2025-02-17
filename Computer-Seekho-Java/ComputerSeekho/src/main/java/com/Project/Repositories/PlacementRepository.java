package com.Project.Repositories;

import org.springframework.stereotype.Repository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.Project.DTO.PlacedStudentDTO;
import com.Project.Entities.Placement;

import jakarta.transaction.Transactional;
import java.util.List;


@Repository
public interface PlacementRepository extends JpaRepository<Placement, Integer> {
    @Query("SELECT new com.Project.DTO.PlacedStudentDTO( " +
           "p.batch.batchId, p.batch.batchName , p.studentID.studentName ,p.studentID.photoUrl, p.recruiterID.recruiterName) " +
           "FROM Placement p " +
           "JOIN p.batch b " +
           "JOIN p.studentID s " +
           "JOIN p.recruiterID r " +
           "ORDER BY p.batch.batchId")
    List<PlacedStudentDTO> fetchPlacedStudents();

    @Query("SELECT new com.Project.DTO.PlacedStudentDTO( " +
           "p.batch.batchId, p.batch.batchName , p.studentID.studentName ,p.studentID.photoUrl, p.recruiterID.recruiterName) " +
           "FROM Placement p " +
           "JOIN p.batch b " +
           "JOIN p.studentID s " +
           "JOIN p.recruiterID r " +
           "WHERE p.batch.batchId = :batchId " +
           "ORDER BY p.batch.batchId")
    List<PlacedStudentDTO> findByBatchId(Integer batchId);
}