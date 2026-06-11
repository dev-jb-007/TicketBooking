package com.example.ticketbooking.Proxy.CinemaProxy;

import com.example.ticketbooking.Enum.Enums;
import com.example.ticketbooking.Models.*;

import java.util.Date;

public class CinemaProxy implements CinemaManage {
    private final CinemaManage CinemaManager;
    private final User user;
    public CinemaProxy(CinemaManage CinemaManager, User user) {
            this.user = user;
            this.CinemaManager = CinemaManager;
    }

    boolean verifyAdminAccess(User user) {
        // Implement access control logic here (e.g., check user roles, permissions, etc.)
        if(user == null || !user.getRole().equals(Enums.Role.ADMIN)) {
            System.out.println("Access denied: User does not have admin privileges.");
            return false;
        }
        return true;
    }
    @Override
    public Cinema createCinema(Enums.City city,String name, String address) {
        if (!verifyAdminAccess(user)) return null;
        return CinemaManager.createCinema(city, name, address);
    }

    @Override
    public void createHall(Cinema cinema, String hallName, int totalSeats, Enums.ScreenType screenType) {
        if (!verifyAdminAccess(user)) return;
        CinemaManager.createHall(cinema, hallName, totalSeats, screenType);
    }

    @Override
    public Show createShow(Cinema cinema, Hall hall, Movie movie, Date startTime, Date endTime, double price){
        if (!verifyAdminAccess(user)) return null;
        return CinemaManager.createShow(cinema, hall, movie, startTime, endTime, price);
    }

    @Override
    public Movie createMovie(String name, int duration_in_minutes, Enums.Genre genre, Enums.Language language) {
        if (!verifyAdminAccess(user)) return null;
        return CinemaManager.createMovie(name, duration_in_minutes, genre, language);
    }
}
