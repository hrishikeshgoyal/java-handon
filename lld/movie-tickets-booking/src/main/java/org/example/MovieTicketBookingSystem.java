package org.example;

import org.example.booking.Booking;

import java.util.HashMap;
import java.util.Map;

public class MovieTicketBookingSystem {
    Map<String, Theatre> theatres;
    Booking bm;


    MovieTicketBookingSystem() {
        theatres = new HashMap<>();
    }

    public void addTheatre(Theatre t) {
        theatres.put(t.id, t);
    }

    public Booking startNewBooking() {
        Booking booking = new Booking(theatres);
        displayAllShows();
        return booking;
    }
    public void displayAllShows() {
        theatres.entrySet().forEach(e -> {
            System.out.printf("All shows of Theatre: %s\n", e.getKey());
            e.getValue().displayShows();
        });


    }


    public void selectShow(Booking b, Show s) {
        b.selectShow(s);
    }

    public void selectSeat(Booking b, Seat s) {
        System.out.println("Selecting: "+s);
        b.selectSeat(s);
    }

    public void collectPayment(Booking b) {
        b.collectPayment();
    }

    public void confirmBooking(Booking b) {
        b.selectedSeat.status= Seat.SeatStatus.BOOKED;
        b.confirmBooking();
    }





}
