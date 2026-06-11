package com.example.ticketbooking.Models;

import lombok.Getter;
import lombok.Setter;

import java.util.Date;
import java.util.ArrayList;
@Getter
@Setter
public class Slot {
    private Date from;
    private Date to;
    private ArrayList<Seat> seats;
    private String showId;
    public Slot(Date from, Date to, String showId) {
        this.from = from;
        this.to = to;
        this.showId = showId;
        this.seats = new ArrayList<>();
    }
}