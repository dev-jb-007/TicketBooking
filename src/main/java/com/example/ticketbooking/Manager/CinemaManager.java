package com.example.ticketbooking.Manager;

import com.example.ticketbooking.Enum.Enums;
import com.example.ticketbooking.Models.*;
import com.example.ticketbooking.Proxy.CinemaProxy.CinemaManage;

import java.util.Date;

public class CinemaManager implements CinemaManage {
    @Override
    public Cinema createCinema(Enums.City city,String name, String address) {
        return new Cinema(city,name, address);
    }

    @Override
    public void createHall(Cinema cinema, String hallName, int totalSeats, Enums.ScreenType screenType) {
        Hall hall=new Hall(hallName,totalSeats,screenType);
        System.out.println("Hall created: " + hallName + " with " + totalSeats + " seats and screen type: " + screenType);
        cinema.addHall(hall);
    }

    @Override
    public Show createShow(Cinema cinema, Hall hall, Movie movie, Date startTime, Date endTime, double price) {
        //Check if we can add show to the hall
        if(hall.canAddShow(startTime,endTime)){
            Show show = new Show(movie, hall, startTime, endTime, price, cinema);
            hall.getSlots().add(new Slot(startTime, endTime, show.getShowId()));
            System.out.println("Show created for movie: " + movie.getName() + " in hall: " + hall.getName() + " from " + startTime + " to " + endTime);
            return show;
        }
        else{
            System.out.println("Cannot create show due to time conflict in hall: " + hall.getName());
            return null;
        }
    }

    @Override
    public Movie createMovie(String name, int duration_in_minutes, Enums.Genre genre, Enums.Language language) {
        return new Movie(name, duration_in_minutes, genre, language);
    }
}
