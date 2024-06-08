package org.example;

import java.util.HashMap;
import java.util.Map;

public class Theatre {
    public String id;
    Map<Integer, Show> shows;

    Theatre(String id) {
        this.id = id;
        shows = new HashMap<>();
    }

    void addShow(Show s) {
        shows.put(s.id, s);
    }
    public void displayShows(){

        shows.values().forEach(v-> v.display());
    }

}
