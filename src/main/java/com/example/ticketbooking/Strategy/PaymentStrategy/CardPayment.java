package com.example.ticketbooking.Strategy.PaymentStrategy;

import com.example.ticketbooking.Builder.Payment;
import com.example.ticketbooking.Models.User;
import com.example.ticketbooking.Enum.Enums;
import java.util.Date;
import java.util.Scanner;

public class CardPayment implements PaymentStrategy {

    private final String cardNumber;
    private final String cardHolderName;
    private final String expiryDate;
    private final String cvv;

    // New no-arg constructor: creates its own Scanner and reads input (synchronized on System.in)
    public CardPayment() {
        String cn, ch, ex, cv;
        synchronized (System.in) {
            Scanner sc = new Scanner(System.in);
            System.out.print("Enter card number: ");
            cn = sc.nextLine().trim();
            System.out.print("Enter card holder name: ");
            ch = sc.nextLine().trim();
            System.out.print("Enter expiry date (MM/YY or MM/YYYY): ");
            ex = sc.nextLine().trim();
            System.out.print("Enter CVV: ");
            cv = sc.nextLine().trim();
            // do not close sc (it would close System.in)
        }
        this.cardNumber = cn;
        this.cardHolderName = ch;
        this.expiryDate = ex;
        this.cvv = cv;
    }

    @Override
    public Payment processPayment(User user, double amount) {
        // Simulate card processing and return a built Payment object
        Payment payment = new Payment.PaymentBuilder(Enums.PaymentType.CARD, amount, new Date(), user, Enums.PaymentStatus.PENDING)
                .setDescription("Card payment processed for card ending with " + (cardNumber.length() > 4 ? cardNumber.substring(cardNumber.length() - 4) : cardNumber))
                .build();
        return payment;
    }
}
