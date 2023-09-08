package com.ayushman.mvc.entity;

public class Bookings {
    private int bookingId;
    private int flightId;
    private int passengerId;
    private String date;

    public Bookings(){}

    public Bookings(int bookingId, int flightId, int passengerId, String date) {
        this.bookingId = bookingId;
        this.flightId = flightId;
        this.passengerId = passengerId;
        this.date = date;
    }

    public int getBookingId() {
        return bookingId;
    }

    public void setBookingId(int bookingId) {
        this.bookingId = bookingId;
    }

    public int getFlightId() {
        return flightId;
    }

    public void setFlightId(int flightId) {
        this.flightId = flightId;
    }

    public int getPassengerId() {
        return passengerId;
    }

    public void setPassengerId(int passengerId) {
        this.passengerId = passengerId;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    @Override
    public String toString() {
        return "Bookings{" +
                "bookingId=" + bookingId +
                ", flightId=" + flightId +
                ", passengerId=" + passengerId +
                ", date='" + date + '\'' +
                '}';
    }
}
