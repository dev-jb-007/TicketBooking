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

     User(UserBuilder builder) {
         this.name = builder.name;
         this.city = builder.city;
         this.role = builder.role;
    }
    public static class UserBuilder{
         String name;
         Enums.City city;
         Enums.Role role;

        public UserBuilder setName(String name) {
            this.name = name;
            return this;
        }
        public UserBuilder setCity(Enums.City city) {
            this.city = city;
            return this;
        }
        public UserBuilder setRole(Enums.Role role) {
            this.role = role;
            return this;
        }
        public User build() {
            return new User(this);
        }
    }
}
