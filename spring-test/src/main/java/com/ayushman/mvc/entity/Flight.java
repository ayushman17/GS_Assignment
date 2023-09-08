package com.ayushman.mvc.entity;

public class Flight {
    private String flightId;
    private int seats;
    private String source;
    private String destination;
    private double fare;

    public Flight(){}
    public Flight(String flightId, int seats, String source, String destination, double fare) {
        this.flightId = flightId;
        this.seats = seats;
        this.source = source;
        this.destination = destination;
        this.fare = fare;
    }

    public String getFlightId() {
        return flightId;
    }

    public int getSeats() {
        return seats;
    }

    public void setSeats(int seats) {
        this.seats = seats;
    }

    public String getSource() {
        return source;
    }

    @Override
    public String toString() {
        return  "flightId='" + flightId + '\'' +
                ", companyName='" + seats + '\'' +
                ", source='" + source + '\'' +
                ", destination='" + destination + '\'' +
                ", fare=" + fare;
    }

    public String getDestination() {
        return destination;
    }

    public double getFare() {
        return fare;
    }
}