package com.Project.DTO;

import java.time.LocalDate;

import lombok.Data;

@Data
public class PaymentDTO {
    private String studentName;
    private String studentEmail;
    private int amount;
    private LocalDate paymentDate;
    private String paymentTypeDesc;

    public PaymentDTO(String studentName, String studentEmail, int amount, LocalDate paymentDate, String paymentTypeDesc) {
        this.studentName = studentName;
        this.studentEmail = studentEmail;
        this.amount = amount;
        this.paymentDate = paymentDate;
        this.paymentTypeDesc = paymentTypeDesc;
    }

    // // Getters & Setters
    // public String getStudentName() { return studentName; }
    // public String getStudentEmail() { return studentEmail; }
    // public int getAmount() { return amount; }
    // public LocalDate getPaymentDate() { return paymentDate; }
    // public String getPaymentTypeDesc() { return paymentTypeDesc; }
}
