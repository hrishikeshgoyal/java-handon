package org.example;

import org.example.booking.Booking;

public class Main {
    public static void main(String[] args) {

        Screen s1 = new Screen("1");
        Screen s2 = new Screen("2");

        s1.addSeats(Seat.SeatType.NORMAL, 10, 100);
        s1.addSeats(Seat.SeatType.PREMIUM, 5, 200);

        Movie m1 = new Movie("ABC");
        Movie m2 = new Movie("DEF");
        Show show1 = new Show(1, s1, "3pm", m1);
        Show show2 = new Show(2, s2, "3pm", m2);


        Theatre t = new Theatre("T1");
        t.addShow(show1);
        t.addShow(show2);

        MovieTicketBookingSystem mtbs = new MovieTicketBookingSystem();
        mtbs.addTheatre(t);

        Booking b = mtbs.startNewBooking();
        mtbs.selectShow(b, show1);
        mtbs.selectSeat(b, s1.getAllSeats(Seat.SeatType.NORMAL).get(0));
        mtbs.collectPayment(b);
        mtbs.confirmBooking(b);

        Booking b2 = mtbs.startNewBooking();
        mtbs.selectShow(b2, show1);
        mtbs.selectSeat(b2, s1.getAllSeats(Seat.SeatType.PREMIUM).get(0));
        mtbs.collectPayment(b2);
        mtbs.confirmBooking(b2);


        Booking b3 = mtbs.startNewBooking();
        mtbs.selectShow(b3, show1);
        mtbs.selectSeat(b3, s1.getAllSeats(Seat.SeatType.PREMIUM).get(0));
        mtbs.collectPayment(b3);
        mtbs.confirmBooking(b3);
    }
}