package com.example.ticketbooking.Strategy.PaymentStrategy;

import com.example.ticketbooking.Builder.Payment;
import com.example.ticketbooking.Models.User;
import com.example.ticketbooking.Enum.Enums;
import java.util.Date;
import java.util.Scanner;

public class UPIpayment implements PaymentStrategy {

    private final String upiId;

    public UPIpayment() {
        String id;
        synchronized (System.in) {
            Scanner sc = new Scanner(System.in);
            System.out.print("Enter UPI id: ");
            id = sc.nextLine().trim();
            // do not close sc (it would close System.in)
        }
        this.upiId = id;
    }
    @Override
    public Payment processPayment(User user, double amount) {
        // Simulate UPI processing and return a built Payment object
        Payment payment = new Payment.PaymentBuilder(Enums.PaymentType.UPI, amount, new Date(), user, Enums.PaymentStatus.PENDING)
                .setDescription("UPI payment processed for UPI ID: " + upiId)
                .build();
        return payment;
    }
}
