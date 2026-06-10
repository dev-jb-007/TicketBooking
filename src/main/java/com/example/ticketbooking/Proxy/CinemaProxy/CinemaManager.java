package com.example.ticketbooking.Proxy.CinemaProxy;

import com.example.ticketbooking.Enum.Enums;
import com.example.ticketbooking.Models.Cinema;
import com.example.ticketbooking.Models.Movie;

public class CinemaManager implements CinemaManage{
    @Override
    public void createCinema(String name, String city, String address) {
        // Implementation for creating a cinema
    }

    @Override
    public void createHall(Cinema cinema, String hallName, int totalSeats, Enums.ScreenType screenType) {
        // Implementation for creating a hall in a cinema
    }

    @Override
    public void createShow(Cinema cinema, String hallName, Movie movie, String startTime, String endTime) {
        // Implementation for creating a show in a hall of a cinema
    }

    @Override
    public void createMovie(String name, int duration_in_minutes, Enums.Genre genre, Enums.Language language) {
        // Implementation for creating a movie
    }
}
