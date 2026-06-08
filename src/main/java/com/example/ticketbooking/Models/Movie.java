package com.example.ticketbooking.Models;


import com.example.ticketbooking.Enum.Enums;

public class Movie {
    private String name;
    private int duration_in_minutes;
    private Enums.Genre genre;
    private Enums.Language language;

    // Full-args constructor (enum types)
    public Movie(String name, int duration_in_minutes, Enums.Genre genre, Enums.Language language) {
        this.name = name;
        this.duration_in_minutes = duration_in_minutes;
        this.genre = genre;
        this.language = language;
    }

    // Getters and setters
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getDuration_in_minutes() {
        return duration_in_minutes;
    }

    public void setDuration_in_minutes(int duration_in_minutes) {
        this.duration_in_minutes = duration_in_minutes;
    }

    public Enums.Genre getGenre() {
        return genre;
    }

    public void setGenre(Enums.Genre genre) {
        this.genre = genre;
    }

    public Enums.Language getLanguage() {
        return language;
    }

    public void setLanguage(Enums.Language language) {
        this.language = language;
    }
}
