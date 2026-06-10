package com.example.ticketbooking.Builder;

import com.example.ticketbooking.Enum.Enums;
import com.example.ticketbooking.Models.User;
import lombok.Getter;

import java.util.Date;
@Getter
public class Payment {
    // 1. Make fields private and final for immutability
    private final Enums.PaymentType paymentType;
    private final double amount;
    private final Date paymentDate;
    private final User user;
    private Enums.PaymentStatus paymentStatus;

    public void setPaymentStatus(Enums.PaymentStatus paymentStatus) {
        this.paymentStatus = paymentStatus;
    }

    // Optional fields
    private final String description;
    private final String phoneNumber;

    // 2. Constructor should ideally be private to force the use of the Builder
    private Payment(PaymentBuilder builder) {
        this.paymentType = builder.paymentType;
        this.amount = builder.amount;
        // Defensive copy to avoid exposing mutable Date
        this.paymentDate = new Date(builder.paymentDate.getTime());
        this.user = builder.user;
        this.paymentStatus = builder.paymentStatus;
        this.description = builder.description;
        this.phoneNumber = builder.phoneNumber;
    }

    public static class PaymentBuilder {
        // Mandatory fields
        private final Enums.PaymentType paymentType;
        private final double amount;
        private final Date paymentDate;
        private final User user;
        private final Enums.PaymentStatus paymentStatus;

        // Optional fields initialized to default values (null)
        private String description;
        private String phoneNumber;

        // 3. Enforce mandatory fields through the Builder's constructor
        public PaymentBuilder(Enums.PaymentType paymentType, double amount, Date paymentDate, User user, Enums.PaymentStatus paymentStatus) {
            this.paymentType = paymentType;
            this.amount = amount;
            // Defensive copy to avoid sharing mutable Date between callers and the builder
            this.paymentDate = new Date(paymentDate.getTime());
            this.user = user;
            this.paymentStatus = paymentStatus;
        }

        // 4. Create fluent setters ONLY for the optional fields
        public PaymentBuilder setDescription(String description) {
            this.description = description;
            return this;
        }

        public PaymentBuilder setPhoneNumber(String phoneNumber) {
            this.phoneNumber = phoneNumber;
            return this;
        }

        // Build method
        public Payment build() {
            return new Payment(this);
        }
    }
}