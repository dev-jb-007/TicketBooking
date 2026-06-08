package com.example.ticketbooking.Models;

import com.example.ticketbooking.Enum.Enums;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class User {
    String name;
    Enums.City city;
    Enums.Role role;

     User(String name, Enums.City city, Enums.Role role) {
        this.name = name;
        this.city = city;
        this.role = role;
    }
}
