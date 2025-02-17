package com.Project.Services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.Project.DTO.PaymentDTO;
import com.Project.Entities.Payment;
import com.Project.Repositories.PaymentRepository;

import java.util.List;

@Service
public class PaymentServiceImpl implements PaymentService {

    @Autowired
    private PaymentRepository paymentRepository;

    @Override
    public Payment getPaymentById(int paymentId) {
        return paymentRepository.findById(paymentId).orElse(null);
    }

    @Override
    public List<Payment> getAllPayments() {
        return paymentRepository.findAll();
    }

    @Override
    public Payment savePayment(Payment payment) {
        Payment payment2 = paymentRepository.save(payment);
        System.out.println(payment2.getStudent().getPaymentDue());
        paymentRepository.updatePaymentDue(payment.getStudent().getStudentId(), payment2.getAmount());
        return payment2;
    }

    // @Override
    // public Payment updatePayment(Payment payment) {
    //     return paymentRepository.save(payment);
    // }

    // @Override
    // public void deletePayment(int paymentId) {
    //     paymentRepository.deleteById(paymentId);
    // }

    @Override
    public boolean existsByStudentId(int studentId) {
        return paymentRepository.existsByStudentStudentId(studentId);
    }

    @Override
    public PaymentDTO getPaymentDTOById(int paymentId) {
       return paymentRepository.getPaymentOptional(paymentId).get();
    }
}