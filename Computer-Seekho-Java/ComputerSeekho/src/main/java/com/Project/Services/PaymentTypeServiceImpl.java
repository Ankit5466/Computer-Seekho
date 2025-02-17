package com.Project.Services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.Project.Entities.PaymentType;
import com.Project.Repositories.PaymentTypeRepository;

@Service
public class PaymentTypeServiceImpl implements PaymentTypeService {

    @Autowired
    private PaymentTypeRepository paymentTypeRepository;

    @Override
    public List<PaymentType> getAllPayments() {
        return paymentTypeRepository.findAll();
    }

    @Override
    public PaymentType getPaymentById(Integer paymentId) {
        Optional<PaymentType> payment = paymentTypeRepository.findById(paymentId);
        return payment.orElse(null); 
    }

    @Override
    public PaymentType addPaymentType(PaymentType paymentType) {
        return paymentTypeRepository.save(paymentType);
    }
}
