package com.example.ticketbooking.Manager;

import com.example.ticketbooking.Builder.Payment;
import com.example.ticketbooking.Enum.Enums;
import com.example.ticketbooking.Models.Booking;
import com.example.ticketbooking.Models.Seat;
import com.example.ticketbooking.Models.Show;
import com.example.ticketbooking.Models.User;
import com.example.ticketbooking.Strategy.PaymentStrategy.PaymentStrategy;

import java.util.ArrayList;

//Singleton Class to manage all booking related operations like creating a booking, cancelling a booking, etc.
public class BookingManager {
    private volatile static BookingManager instance;

    private PaymentStrategy paymentStrategy;

    private BookingManager() {
        // Private constructor to prevent instantiation
    }

    public static BookingManager getInstance() {
        if (instance == null) {
            synchronized (BookingManager.class) {
                if (instance == null) {
                    instance = new BookingManager();
                }
            }
        }
        return instance;
    }

    void setPaymentStrategy(PaymentStrategy paymentStrategy) {
        this.paymentStrategy = paymentStrategy;
    }

    Booking bookShow(Show show, User user, int numberOfSeats) {
        //Check if the show has enough available seats
        if (show.getAvailableSeats() < numberOfSeats) {
            throw new RuntimeException("Not enough seats available");
        }
        //Let use select seats
        ArrayList<Seat> selectedSeats=show.selectSeats(numberOfSeats);

        //Create a booking
        Booking booking = new Booking(user, show, selectedSeats, Enums.BookingStatus.PENDING);
        //Process payment
        Payment payment = paymentStrategy.processPayment(user,show.getPrice() * numberOfSeats);
        if(payment.getPaymentStatus()== Enums.PaymentStatus.SUCCESS){
            booking.setBookingStatus(Enums.BookingStatus.CONFIRMED);
        }else{
            booking.setBookingStatus(Enums.BookingStatus.CANCELLED);
        }
        booking.setPayment(payment);
        return booking;

    }
}
