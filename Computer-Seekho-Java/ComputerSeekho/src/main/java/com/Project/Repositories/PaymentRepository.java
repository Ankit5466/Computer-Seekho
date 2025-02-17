package com.Project.Repositories;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.Project.DTO.PaymentDTO;
import com.Project.Entities.Payment;

import jakarta.transaction.Transactional;

@Repository
public interface PaymentRepository extends JpaRepository<Payment, Integer> {
    boolean existsByStudentStudentId(int studentId); 

    @Modifying
    @Transactional
    @Query(value="""
        update Student s set s.payment_due = s.payment_due - ?2 where s.student_id = ?1
    """,nativeQuery = true)
    void updatePaymentDue(int id, double amt);

    @Query("SELECT new com.Project.DTO.PaymentDTO(s.studentName, s.studentEmail, p.amount, p.paymentDate, pt.paymentTypeDesc) " +
    "FROM Payment p " +
    "JOIN p.student s " +
    "JOIN p.paymentTypeId pt " +
    "WHERE p.paymentId = :id")
    Optional<PaymentDTO> getPaymentOptional(@Param("id") int id);
}