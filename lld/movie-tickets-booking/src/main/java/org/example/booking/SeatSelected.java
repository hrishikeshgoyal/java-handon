package org.example.booking;

import org.example.Seat;
import org.example.Show;

public class SeatSelected implements  BookingState{
    Booking b;
    SeatSelected(Booking b) {
        this.b = b;
    }

    @Override
    public void selectShow(Show show) {
        System.out.println("Invalid Operation");
    }

    @Override
    public void selectSeat(Seat seat) {
        System.out.println("Invalid Operation");
    }

    @Override
    public void collectPayment() {
        System.out.println("Invoking payment gateway..");

        System.out.printf("Money received.. %d\n", b.selectedSeat.price);
        b.setCurrentState(b.paymentReceivedState);

    }

    @Override
    public Booking confirmBooking() {
        System.out.println("Invalid Operation");
        return null;
    }
}
