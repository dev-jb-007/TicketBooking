package com.example.ticketbooking.Proxy.CinemaProxy;

import com.example.ticketbooking.Enum.Enums;
import com.example.ticketbooking.Models.Cinema;
import com.example.ticketbooking.Models.Movie;

public interface CinemaManage {
    void createCinema(String name, String city,String address);
    void createHall(Cinema cinema, String hallName, int totalSeats, Enums.ScreenType screenType);
    void createShow(Cinema cinema, String hallName, Movie movie, String startTime, String endTime);
    void createMovie(String name, int duration_in_minutes, Enums.Genre genre, Enums.Language language);
}
