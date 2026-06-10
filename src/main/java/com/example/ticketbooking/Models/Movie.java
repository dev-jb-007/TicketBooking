package com.example.ticketbooking.Models;


import com.example.ticketbooking.Enum.Enums;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;

@Setter
@Getter
public class Movie {
    private String name;
    private int duration_in_minutes;
    private Enums.Genre genre;
    private Enums.Language language;
    private ArrayList<Show> shows;

    // Full-args constructor (enum types)
    public Movie(String name, int duration_in_minutes, Enums.Genre genre, Enums.Language language) {
        this.name = name;
        this.duration_in_minutes = duration_in_minutes;
        this.genre = genre;
        this.language = language;
    }
}
