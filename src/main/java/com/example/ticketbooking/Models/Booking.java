package com.example.ticketbooking.Models;

import com.example.ticketbooking.Builder.Payment;
import com.example.ticketbooking.Enum.Enums;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;

@Getter
@Setter
public class Booking {
    User user;
    Show show;
    ArrayList<Seat> seats;
    Enums.BookingStatus bookingStatus;
    Payment payment;

    public Booking(User user, Show show, ArrayList<Seat> seats, Enums.BookingStatus bookingStatus) {
        this.user = user;
        this.show = show;
        this.seats = seats;
        this.bookingStatus = bookingStatus;
    }
}
