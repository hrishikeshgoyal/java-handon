package org.example;

import javafx.util.Pair;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class Elevator {
    int id;
    private int currentFloor;
    private int status; // 1 for moving up , -1 for moving down, 0 idle

    // from & to
    LinkedList<Pair<Integer, Integer>> requests;
    public Elevator(int id) {
        this.id = id;
        this.currentFloor = 0;
        this.status = 0;
        requests = new LinkedList<>();
    }


    public synchronized void addRequest(int from, int to) {
        if(requests.size()<5){
            requests.add(new Pair<>(from, to));
            notify();
        }
    }

    public synchronized void start() {
        while(true) {
            if(requests.isEmpty()) {
                try {
                    System.out.printf("elevator: %d sitting idle\n", id);
                    wait();
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
            var req = requests.peek();
            var from = req.getKey();
            var to = req.getValue();
            move(currentFloor, from);
            System.out.println("Elevator opens... ");
            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            System.out.println("Elevator closes... ");
            move(from, to);
            requests.pop();
        }
    }

    private synchronized void move(int from, int to) {
        if(to > from) {
            for(int i=from; i>to; i--) {
                System.out.printf("elevator: %d, at floor: %d\n", id, i);
                currentFloor = i;
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
        }
        if(from < to) {
            for(int i=from; i<to; i++) {
                System.out.printf("elevator: %d, at floor: %d\n", id, i);
                currentFloor = i;
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
        }
        System.out.println("elevator reached: " + to);
    }

    public synchronized int getCurrentFloor() {
        return currentFloor;
    }
    public int getStatus() {
        return status;
    }
    public int getId() {
        return id;
    }

    public synchronized int getPendingRequests() {
        return requests.size();
    }

}
