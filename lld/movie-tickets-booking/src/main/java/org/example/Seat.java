package org.example;

import com.sun.javafx.binding.StringFormatter;

public class Seat {
    int id;
    public Seat(SeatType type, int id, int price) {
        this.id = id;
        seatType = type;
        status = SeatStatus.AVAILABLE;
        this.price = price;
    }
    public enum SeatType {
        NORMAL,
        PREMIUM,
    }

    @Override
    public String toString() {
        return String.format("<%d, %s, %d>", id, status, price);
    }
    public  SeatType seatType;
    public int price;
    public enum SeatStatus {
        AVAILABLE,
        BOOKED,
    }
    public SeatStatus status;

}
