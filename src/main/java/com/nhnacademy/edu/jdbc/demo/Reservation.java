package com.nhnacademy.edu.jdbc.demo;

public class Reservation {
    private int passengerNo;
    private int no;
    private String reservedDate;

    public Reservation(int passengerNo, int no, String reservedDate) {
        this.passengerNo = passengerNo;
        this.no = no;
        this.reservedDate = reservedDate;

    }

    public int getPassengerNo() {
        return passengerNo;
    }

    public int getNo() {
        return no;
    }

    public String getReservedDate() {
        return reservedDate;
    }


}
