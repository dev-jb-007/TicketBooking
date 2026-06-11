package com.example.ticketbooking.Enum;

/**
 * Central place for enums used across the project.
 * Kept as a single file "Enums.java" with nested public enums so other packages can reference
 * Enums.Genre, Enums.Language, Enums.SeatStatus without adding multiple top-level public types.
 */
public class Enums {
    public enum Genre {
        ACTION, COMEDY, DRAMA, HORROR, ROMANCE, THRILLER, DOCUMENTARY, ANIMATION, OTHER
    }

    public enum City{
        MUMBAI, DELHI, BANGALORE, HYDERABAD, CHENNAI, KOLKATA, OTHER
    }
    public enum Language {
        ENGLISH, HINDI, FRENCH, SPANISH, OTHER
    }

    public enum SeatStatus {
        EMPTY, RESERVED, OCCUPIED, UNAVAILABLE
    }

    public enum ScreenType{
        TWO_D, THREE_D, IMAX, FOUR_D, OTHER
    }

    public enum Role{
        ADMIN,CUSTOMER
    }

    public enum PaymentType{
        CARD, NET_BANKING, UPI, OTHER
    }

    public enum BookingStatus{
        CONFIRMED, CANCELLED, PENDING, REVERT
    }

    public enum PaymentStatus{
        SUCCESS, FAILED, PENDING, REVERT, REFUNDED
    }
    // Note: String-to-enum conversion logic has been intentionally removed. Consumers should
    // construct enums directly (e.g., Enums.Genre.ACTION) or implement their own mapping.
}
