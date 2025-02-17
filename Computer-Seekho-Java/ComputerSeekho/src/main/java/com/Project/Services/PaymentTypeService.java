package com.Project.Services;

import java.util.List;
import com.Project.Entities.PaymentType;

public interface PaymentTypeService {
    List<PaymentType> getAllPayments();
    PaymentType getPaymentById(Integer id);
    PaymentType addPaymentType(PaymentType payment);
}
