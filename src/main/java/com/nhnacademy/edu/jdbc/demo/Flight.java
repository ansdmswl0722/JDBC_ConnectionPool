package com.nhnacademy.edu.jdbc.demo;

public class Flight {

    private int flightNo;
    private int aircraftNo;
    private String departures;
    private String arrival;
    private String price;

    private String flightDate;

    public Flight(int flightNo, int aircraftNo, String departures, String arrival, String price, String flightDate) {
        this.flightNo = flightNo;
        this.aircraftNo = aircraftNo;
        this.departures = departures;
        this.arrival = arrival;
        this.price = price;
        this.flightDate = flightDate;
    }

    public int getFlightNo() {
        return flightNo;
    }

    public int getAircraftNo() {
        return aircraftNo;
    }

    public String getDepartures() {
        return departures;
    }

    public String getArrival() {
        return arrival;
    }

    public String getPrice() {
        return price;
    }

    public String getFlightDate() {
        return flightDate;
    }
}
