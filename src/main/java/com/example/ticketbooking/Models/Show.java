package com.example.ticketbooking.Models;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;
@Getter
@Setter
@AllArgsConstructor
public class Show{
    private Movie movie;
    private Hall hall;
    private Date startTime;
    private Date endTime;
    private int duration;
    //Cinema
    private double price;



}