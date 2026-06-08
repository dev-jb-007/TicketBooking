package com.example.ticketbooking.Strategy.PaymentStrategy;

import com.example.ticketbooking.Models.Payment;
import com.example.ticketbooking.Models.User;

public interface PaymentStrategy {
    public Payment processPayment(User user, double amount);
}
