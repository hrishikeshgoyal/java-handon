package org.example.booking;

import org.example.Seat;
import org.example.Show;

public class ShowSelected implements BookingState{
    Booking b;
    ShowSelected(Booking b) {
        this.b = b;
    }

    @Override
    public void selectShow(Show show) {
        System.out.println("Invalid Operation");
    }

    @Override
    public void selectSeat(Seat seat) {
        b.setSelectSeat(seat);
        b.setCurrentState(b.seatSelectedState);
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
