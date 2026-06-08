package com.example.ticketbooking.Strategy.PaymentStrategy;

import com.example.ticketbooking.Models.Payment;
import com.example.ticketbooking.Models.User;

public class UPIpayment implements PaymentStrategy {

    private String upiId;

    public UPIpayment(String upiId) {
        this.upiId = upiId;
    }
    @Override
    public Payment processPayment(User user, double amount) {
        return null;
    }
}
