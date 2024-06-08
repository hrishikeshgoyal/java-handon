package org.example.booking;

import org.example.Seat;
import org.example.Show;

public interface BookingState {
    void selectShow(Show show);
    void selectSeat(Seat seat);
    void collectPayment();

    Booking confirmBooking();
}
