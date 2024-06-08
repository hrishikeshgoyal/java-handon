package org.example.booking;

import org.example.Seat;
import org.example.Show;

public class PaymentReceived implements BookingState{

    Booking b;
    PaymentReceived(Booking b) {
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
        System.out.println("Invalid Operation");
    }

    @Override
    public Booking confirmBooking() {
        System.out.println("Booking is confirm");
        b.setCurrentState(b.idleState);
        return b;
    }
}
