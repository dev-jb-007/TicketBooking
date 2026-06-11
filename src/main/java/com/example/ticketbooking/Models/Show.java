package com.example.ticketbooking.Models;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.Date;
import java.util.Scanner;
@Getter
@Setter
@AllArgsConstructor
public class Show{
    private String showId;
    private Movie movie;
    private Hall hall;
    private Date startTime;
    private Date endTime;
    private int duration;
    //Cinema
    private Cinema playedAt;
    private double price;

    public Show(Movie movie, Hall hall, Date startTime, Date endTime, double price, Cinema playedAt) {
        this.showId = "SHOW-" + System.currentTimeMillis(); // simple unique ID generation
        this.movie = movie;
        this.hall = hall;
        this.startTime = startTime;
        this.endTime = endTime;
        this.duration = (int)((endTime.getTime() - startTime.getTime()) / (1000 * 60)); // duration in minutes
        this.price = price;
        this.playedAt = playedAt;
    }

    public int getAvailableSeats(){
        return hall.getAvailableSeatsForShow(this);
    }

    public ArrayList<Seat> selectSeats(int numberOfSeats){
        ArrayList<Seat> availableSeats = hall.getSeatsForShow(this);
        //print avalaible seats and let user select the seats

        if (availableSeats == null || availableSeats.size() < numberOfSeats) {
            throw new RuntimeException("Not enough available seats");
        }

        Scanner scanner = new Scanner(System.in);
        ArrayList<Seat> selected = new ArrayList<>();

        while (true) {
            System.out.println("Available seats for show " + showId + ":");
            for (int i = 0; i < availableSeats.size(); i++) {
                Seat s = availableSeats.get(i);
                // show index (1-based) and seat description; rely on Seat.toString() or simple identifier
                System.out.println((i + 1) + ". " + s);
            }
            System.out.println("Please select " + numberOfSeats + " seat(s) by entering their indices (space-separated, 1-based):");
            String line = scanner.nextLine().trim();
            if (line.isEmpty()) {
                System.out.println("No input detected. Try again.");
                continue;
            }
            String[] parts = line.split("\\s+|,");
            if (parts.length != numberOfSeats) {
                System.out.println("You entered " + parts.length + " selections; please enter exactly " + numberOfSeats + " indices.");
                continue;
            }

            boolean ok = true;
            selected.clear();
            for (String p : parts) {
                try {
                    int idx = Integer.parseInt(p);
                    int zeroBased = idx - 1;
                    if (zeroBased < 0 || zeroBased >= availableSeats.size()) {
                        System.out.println("Index out of range: " + idx);
                        ok = false;
                        break;
                    }
                    Seat seat = availableSeats.get(zeroBased);
                    if (selected.contains(seat)) {
                        System.out.println("Duplicate selection: " + idx);
                        ok = false;
                        break;
                    }
                    selected.add(seat);
                } catch (NumberFormatException e) {
                    System.out.println("Invalid number: " + p);
                    ok = false;
                    break;
                }
            }

            if (ok && selected.size() == numberOfSeats) {
                // successful selection
                System.out.println("Selected seats:");
                for (Seat s : selected) {
                    System.out.println(s);
                }
                return selected;
            } else {
                System.out.println("Selection invalid. Please try again.");
            }
        }
    }


}