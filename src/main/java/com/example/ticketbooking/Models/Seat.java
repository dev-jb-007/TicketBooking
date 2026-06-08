package com.example.ticketbooking.Models;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Seat {
    // ...existing code...
    private int row;
    private char column;
    private boolean isEmpty;

    // Convenience constructor: new seat defaults to empty
    public Seat(int row, char column) {
        this(row, column, true);
    }

    // Full constructor
    public Seat(int row, char column, boolean isEmpty) {
        this.row = row;
        this.column = column;
        this.isEmpty = isEmpty;
    }
    public boolean isEmpty() {
        return isEmpty;
    }

    public void setEmpty(boolean isEmpty) {
        this.isEmpty = isEmpty;
    }

    @Override
    public String toString() {
        return String.format("Seat{row=%d, column=%c, isEmpty=%b}", row, column, isEmpty);
    }
    // ...existing code...
}
