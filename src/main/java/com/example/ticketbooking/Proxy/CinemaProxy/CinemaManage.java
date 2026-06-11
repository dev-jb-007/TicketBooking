package com.example.ticketbooking.Proxy.CinemaProxy;

import com.example.ticketbooking.Enum.Enums;
import com.example.ticketbooking.Models.Cinema;
import com.example.ticketbooking.Models.Hall;
import com.example.ticketbooking.Models.Movie;
import com.example.ticketbooking.Models.Show;

import java.util.Date;

public interface CinemaManage {
    public Cinema createCinema(Enums.City city,String name,String address);
    public void createHall(Cinema cinema, String hallName, int totalSeats, Enums.ScreenType screenType);
    public Show createShow(Cinema cinema, Hall hall, Movie movie, Date startTime, Date endTime, double price);
    public Movie createMovie(String name, int duration_in_minutes, Enums.Genre genre, Enums.Language language);
}
