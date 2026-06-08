package com.example.ticketbooking.Models;

import java.util.Date;
import java.util.ArrayList;
public class Slot {
    private Date from;
    private Date to;
    private ArrayList<Seat> seats;
    private String showId;

    // Getters and setters
    public Date getFrom() {
        return from;
    }

    public void setFrom(Date from) {
        this.from = from;
    }

    public Date getTo() {
        return to;
    }

    public void setTo(Date to) {
        this.to = to;
    }

    public ArrayList<Seat> getSeats() {
        return seats;
    }

    public void setSeats(ArrayList<Seat> seats) {
        this.seats = seats;
    }

    public String getShowId() {
        return showId;
    }

    public void setShowId(String showId) {
        this.showId = showId;
    }
}