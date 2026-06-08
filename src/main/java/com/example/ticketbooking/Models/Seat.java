package com.example.ticketbooking.Models;

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

    public int getRow() {
        return row;
    }

    public void setRow(int row) {
        this.row = row;
    }

    public char getColumn() {
        return column;
    }

    public void setColumn(char column) {
        this.column = column;
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
