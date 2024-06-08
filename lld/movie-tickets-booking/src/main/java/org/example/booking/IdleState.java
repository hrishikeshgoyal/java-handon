package org.example.booking;

import org.example.Seat;
import org.example.Show;

import java.util.Scanner;

public class IdleState implements  BookingState{
    Booking b;
    Scanner sc;
    IdleState(Booking b) {
        this.b = b;
        this.sc = new Scanner(System.in);
    }
    @Override
    public void selectShow(Show s) {
        b.selectedShow = s;
        b.setCurrentState(b.showSelectedState);
        b.selectedShow.displaySeats();
    }

    @Override
    public void selectSeat(Seat seat) {
        System.out.println("Invalid Operation");
    }

    @Override
    public void collectPayment() {
        System.out.println("Invalid Operation");
    }

    @Override
    public Booking confirmBooking() {
        System.out.println("Invalid Operation");
        return null;
    }

}
