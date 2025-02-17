package com.Project.Entities;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(name = "payment_type")
@Data
public class PaymentType {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "payment_type_id")
    private int paymentTypeId;

    @Column(name = "payment_type_desc")
    private String paymentTypeDesc;

    // Getters and Setters
    public int getPaymentTypeId() {
        return paymentTypeId;
    }

    public void setPaymentTypeId(int paymentTypeId) {
        this.paymentTypeId = paymentTypeId;
    }

    public String getPaymentTypeDesc() {
        return paymentTypeDesc;
    }

    public void setPaymentTypeDesc(String paymentTypeDesc) {
        this.paymentTypeDesc = paymentTypeDesc;
    }
}