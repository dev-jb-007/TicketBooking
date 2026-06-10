package com.example.ticketbooking.Factory.PaymentFactory;

import com.example.ticketbooking.Strategy.PaymentStrategy.CardPayment;
import com.example.ticketbooking.Strategy.PaymentStrategy.PaymentStrategy;
import com.example.ticketbooking.Strategy.PaymentStrategy.UPIpayment;

//Singleton class
public class PaymentFactory {
    private volatile static PaymentFactory instance;

    private PaymentFactory() {
    }

    public static PaymentFactory getInstance() {
        if (instance == null) {
            synchronized (PaymentFactory.class) {
                if (instance == null) {
                    instance = new PaymentFactory();
                }
            }
        }
        return instance;
    }

    public PaymentStrategy createPayment(String type) {
        switch (type.toLowerCase()) {
            case "card": {
                return new CardPayment();
            }
            case "upi": {
                return new UPIpayment();
            }
            default:
                throw new IllegalArgumentException("Invalid payment type");
        }
    }
}
