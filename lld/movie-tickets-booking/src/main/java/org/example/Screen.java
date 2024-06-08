package org.example;

import java.util.*;

public class Screen {
    String id;
    Map<Seat.SeatType, List<Seat>> seats;

    public Screen(String id) {
        this.id = id;
        seats = new HashMap<>();
    }
    public void display() {
        System.out.printf("Screen: %s\nSeat map:\n", id);
        seats.entrySet().forEach(e-> System.out.printf("Seat Type: %s, seats: %s", e.getKey(), e.getValue()));
    }

    public void addSeats (Seat.SeatType type, int count, int price) {
        var li = seats.getOrDefault(type, new ArrayList<>());
        for(int i=0; i<count; i++) {
            li.add(new Seat(type, i, price));
        }
        seats.put(type, li);
    }

    public List<Seat> getAllSeats(Seat.SeatType st) {
        System.out.println("getAllSeat()\n");
        return seats.get(st);
    }


    public Set<Seat.SeatType> getSeatTypes() {
        return seats.keySet();
    }
}
