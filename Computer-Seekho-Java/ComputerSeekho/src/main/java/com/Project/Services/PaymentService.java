package com.Project.Services;

import com.Project.DTO.PaymentDTO;
import com.Project.Entities.Payment;
import java.util.List;

public interface PaymentService {
    Payment getPaymentById(int id);
    List<Payment> getAllPayments();
    Payment savePayment(Payment payment);
    //Payment updatePayment(Payment payment);
    boolean existsByStudentId(int studentId);
   // void deletePayment(int paymentId);
    PaymentDTO getPaymentDTOById(int paymentId);
}
