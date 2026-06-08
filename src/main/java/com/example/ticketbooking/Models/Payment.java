package com.example.ticketbooking.Models;

import com.example.ticketbooking.Enum.Enums;

import java.util.Date;

public class Payment {
    Enums.PaymentType paymentType;
    double amount;
    Date paymentDate;
    User user;
    Enums.PaymentStatus paymentStatus;
    String description;
    String phoneNumber;

     Payment(PaymentBuilder builder) {
         this.paymentType = builder.paymentType;
         this.amount = builder.amount;
         this.paymentDate = builder.paymentDate;
         this.user = builder.user;
         this.paymentStatus = builder.paymentStatus;
         this.description = builder.description;
         this.phoneNumber = builder.phoneNumber;
    }
    public static class PaymentBuilder {

        //Mandatory fields
        public Enums.PaymentType paymentType;
        double amount;
        Date paymentDate;
        User user;
        Enums.PaymentStatus paymentStatus;

        void PaymentTypeSetter(Enums.PaymentType paymentType) {
            this.paymentType = paymentType;
        }

        void DescriptionSetter(String description){
            this.description=description;
        }
        void PhoneNumberSetter(String phoneNumber){
            this.phoneNumber=phoneNumber;
        }
        //optional fields
        String description;
        String phoneNumber;

        public PaymentBuilder setPaymentType(Enums.PaymentType paymentType) {
            this.paymentType = paymentType;
            return this;
        }
        public PaymentBuilder setAmount(double amount) {
            this.amount = amount;
            return this;
        }
        public PaymentBuilder setPaymentDate(Date paymentDate) {
            this.paymentDate = paymentDate;
            return this;
        }
        public PaymentBuilder setUser(User user) {
            this.user = user;
            return this;
        }
        public PaymentBuilder setPaymentStatus(Enums.PaymentStatus paymentStatus) {
            this.paymentStatus = paymentStatus;
            return this;
        }
        //Build method
        public Payment build(){
            return new Payment(this);
        }
    }
}
