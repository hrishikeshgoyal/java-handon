package org.example;

public class Main {
    public static void main(String[] args) {

        ElevatorController ec = new ElevatorController(7, 3);
        ec.callElevator(3, 6);
//        try {
//            Thread.sleep(2000);
//        } catch (InterruptedException e) {
//            throw new RuntimeException(e);
//        }
        ec.callElevator(0, 5);

//        try {
//            Thread.sleep(1000);
//        } catch (InterruptedException e) {
//            throw new RuntimeException(e);
//        }

        ec.callElevator(7, 3);
//        ec.callElevator(2, 6);
//        ec.callElevator(5, 1);
//        ec.callElevator(4, 0);
//        ec.callElevator(3, 6);
    }
}