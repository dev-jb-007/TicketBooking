package com.example.ticketbooking.Models;

import com.example.ticketbooking.Enum.Enums;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

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
}