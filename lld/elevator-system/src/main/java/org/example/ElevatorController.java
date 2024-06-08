package org.example;

import java.util.HashMap;
import java.util.Map;

public class ElevatorController {
    Map<Integer, Elevator> elevators;
    int totalFloors;

    public ElevatorController(int floorCount, int elevatorCount) {
        totalFloors = floorCount;
        elevators = new HashMap<>();

        for(int i=1; i<=elevatorCount; i++) {
            elevators.put(i, new Elevator(i));
        }
        for(var e: elevators.values()) {
            new Thread(() -> e.start()).start();
        }

    }


    int getOptimalElevator(int from, int dir) {
        int diff=Integer.MAX_VALUE;
        int optimal = -1;
        for(var e: elevators.values()) {
//            System.out.println("checking out elevator: "+ e.id);
            if(e.getPendingRequests() == 0 ) {
//                System.out.println("pending request: "+ e.getPendingRequests() );
                if(diff > Math.abs(e.getCurrentFloor() - from) ){//&& e.getStatus() <= 0) {
//                    System.out.println("inside if : "+ e.getCurrentFloor());
                    diff = Math.abs(e.getCurrentFloor() - from);
                    optimal = e.getId();
                }
//                else  if(e.getCurrentFloor() <= from){// && e.getStatus() >= 0) {
//                    System.out.println("inside else : "+ e.getCurrentFloor());
//                    diff = Math.min(diff, from - e.getCurrentFloor());
//                    optimal = e.getId();
//                }
            }
        }
        return optimal;
    }

    void callElevator(int from, int to) {
        int id = getOptimalElevator(from, to);
        System.out.printf("Assigning elevator %d to serve from: %d, to: %d\n", id, from, to);
        elevators.get(id).addRequest(from, to);
    }



}
