package org.example;

import java.util.HashMap;
import java.util.Map;

public class Show {
    int id;
    public final Screen screen;
    String time;

    Show(int id, Screen screen, String time, Movie m) {
        this.id = id;
        this.screen = screen;
        this.time = time;
        this.movie = m;
    }

    public Movie movie;

    void update(String time, Movie m) {
        this.time = time;
        this.movie = m;
    }

    public void display() {
        System.out.printf("Time: %s, Movie: %s: Screen: %s\n", time, movie.id, screen.id);
    }
    public void displaySeats() {
        screen.display();
    }
}
