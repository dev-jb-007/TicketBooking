package com.example.ticketbooking.Models;

import com.example.ticketbooking.Enum.Enums;

import java.util.List;
import java.util.ArrayList;
public class Hall {
    private String name;
    private int totalSeats;
    private Enums.ScreenType screenType;
    private List<Slot> slots;

    // Getters and setters
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getTotalSeats() {
        return totalSeats;
    }

    public void setTotalSeats(int totalSeats) {
        this.totalSeats = totalSeats;
    }

    public Enums.ScreenType getScreenType() {
        return screenType;
    }

    public void setScreenType(Enums.ScreenType screenType) {
        this.screenType = screenType;
    }

    public List<Slot> getSlots() {
        return (slots == null) ? null : new ArrayList<>(slots);
    }

    public void setSlots(List<Slot> slots) {
        this.slots = (slots == null) ? null : new ArrayList<>(slots);
    }
}