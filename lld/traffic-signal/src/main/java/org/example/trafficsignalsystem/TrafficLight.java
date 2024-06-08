package org.example.trafficsignalsystem;

import java.util.*;

public class TrafficLight {
    private final String id;
    private Signal currentSignal;

    private Map<Signal, Integer> durationMap;

    public TrafficLight(String id, int redDuration, int yellowDuration, int greenDuration) {
        this.id = id;
        this.currentSignal = Signal.RED;
        durationMap = new HashMap<>();
        durationMap.put(Signal.YELLOW, yellowDuration);
        durationMap.put(Signal.GREEN, greenDuration);
        durationMap.put(Signal.RED, redDuration);
    }

    public synchronized void changeSignal(Signal newSignal) {
        currentSignal = newSignal;
        notifyObservers();
    }

    public Signal getCurrentSignal() {
        return currentSignal;
    }

    public int getDuration(Signal s) {
        return durationMap.get(s);
    }

    private void notifyObservers() {
        // Notify observers (e.g., roads) about the signal change
        // ...
    }
}
