package com.example.ticketbooking.Models;

import com.example.ticketbooking.Enum.Enums;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;
import java.util.List;
import java.util.ArrayList;
@Getter
@Setter
@AllArgsConstructor
public class Hall {
    private String name;
    private int totalSeats;
    private Enums.ScreenType screenType;
    private List<Slot> slots;

    public Hall(String name, int totalSeats, Enums.ScreenType screenType) {
        this.name = name;
        this.totalSeats = totalSeats;
        this.screenType = screenType;
        this.slots = new ArrayList<>();
    }

    int getAvailableSeatsForShow(Show show){
        int occupiedSeats = 0;
        for(Slot slot : slots){
            if(show.getShowId().equals(slot.getShowId())){
                for(Seat seat : slot.getSeats()){
                    if(!seat.isEmpty()){
                        occupiedSeats++;
                    }
                }
            }
        }
        return totalSeats - occupiedSeats;
    }
    ArrayList<Seat> getSeatsForShow(Show show){
        ArrayList<Seat> availableSeats = new ArrayList<>();
        for(Slot slot : slots){
            if(show.getShowId().equals(slot.getShowId())){
                for(Seat seat : slot.getSeats()){
                    if(seat.isEmpty()){
                        availableSeats.add(seat);
                    }
                }
            }
        }
        return availableSeats;
    }
    public boolean canAddShow(Date startTime, Date endTime){
        for(Slot slot : slots){
            if(slot.getFrom().compareTo(startTime) <= 0 && startTime.compareTo(slot.getTo()) <= 0){
                return false; // Time conflict
            }
            else if(slot.getFrom().compareTo(endTime) <= 0 && endTime.compareTo(slot.getTo()) <= 0){
                return false; // Time conflict
            }
            return true;
        }
        return true; // No conflict, can add show
    }
}