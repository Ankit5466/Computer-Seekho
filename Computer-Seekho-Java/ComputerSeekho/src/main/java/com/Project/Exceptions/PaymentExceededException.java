package com.Project.Exceptions;

public class PaymentExceededException extends Exception {
    public PaymentExceededException(String message) {
        super(message);
    }
}
