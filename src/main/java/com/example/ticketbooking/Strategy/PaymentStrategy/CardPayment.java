package com.example.ticketbooking.Strategy.PaymentStrategy;

import com.example.ticketbooking.Models.Payment;
import com.example.ticketbooking.Models.User;

public class CardPayment implements PaymentStrategy {

    private String cardNumber;
    private String cardHolderName;
    private String expiryDate;
    private String cvv;

    public CardPayment(String cardNumber, String cardHolderName, String expiryDate, String cvv) {
        this.cardNumber = cardNumber;
        this.cardHolderName = cardHolderName;
        this.expiryDate = expiryDate;
        this.cvv = cvv;
    }

    @Override
    public Payment processPayment(User user, double amount) {
        return null;
    }
}
