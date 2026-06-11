package com.example.ticketbooking.Models;

import com.example.ticketbooking.Enum.Enums;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.HashMap;

@Getter
@Setter
public class Cinema {
    private Enums.City city;
    private String name;
    private String address;
    ArrayList<Hall> halls;
    ArrayList<Show> shows;
    HashMap<Movie, ArrayList<Show>> movieToShowsMap;

    public Cinema(Enums.City city, String name, String address) {
        this.city = city;
        this.name = name;
        this.address = address;
        this.halls = new ArrayList<>();
        this.shows = new ArrayList<>();
        this.movieToShowsMap = new HashMap<>();
    }
    void addShow(Show show) {
        if (shows == null) {
            System.out.println("Shows is null.");
        }
        shows.add(show);
        Movie movie = show.getMovie();
        movieToShowsMap.putIfAbsent(movie, new ArrayList<>());
        movieToShowsMap.get(movie).add(show);
    }
    public void addHall(Hall hall) {
        halls.add(hall);
    }
    ArrayList<Show> getShowsByMovie(Movie movie) {
        return movieToShowsMap.getOrDefault(movie, new ArrayList<>());
    }
}
