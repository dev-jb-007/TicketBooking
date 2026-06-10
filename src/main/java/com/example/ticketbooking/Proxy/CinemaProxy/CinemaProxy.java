package com.example.ticketbooking.Proxy.CinemaProxy;

import com.example.ticketbooking.Enum.Enums;
import com.example.ticketbooking.Models.Cinema;
import com.example.ticketbooking.Models.Movie;
import com.example.ticketbooking.Models.User;

public class CinemaProxy implements CinemaManage {
    private final CinemaManage CinemaManager;
    private final User user;
    public CinemaProxy(CinemaManager CinemaManager,User user) {
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
    public void createCinema(String name, String city, String address) {
        if (!verifyAdminAccess(user)) return;
        CinemaManager.createCinema(name, city, address);
    }

    @Override
    public void createHall(Cinema cinema, String hallName, int totalSeats, Enums.ScreenType screenType) {
        if (!verifyAdminAccess(user)) return;
        CinemaManager.createHall(cinema, hallName, totalSeats, screenType);
    }

    @Override
    public void createShow(Cinema cinema, String hallName, Movie movie, String startTime, String endTime) {
        if (!verifyAdminAccess(user)) return;
        CinemaManager.createShow(cinema, hallName, movie, startTime, endTime);
    }

    @Override
    public void createMovie(String name, int duration_in_minutes, Enums.Genre genre, Enums.Language language) {
        if (!verifyAdminAccess(user)) return;
        CinemaManager.createMovie(name, duration_in_minutes, genre, language);
    }
}
