package org.vendingmachine;

import org.vendingmachine.states.Idle;
import org.vendingmachine.states.MoneyReceived;
import org.vendingmachine.states.Selected;
import org.vendingmachine.states.State;
import org.vendingmachine.states.StatesEnum;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;

public class VendingMachine {
    Map<StatesEnum, State> states;
    State currentState;
    Inventory inventory;
    Monetizer monetizer;

    String currentSelected;

    public static VendingMachine v;

    public VendingMachine(Inventory i, Monetizer m) {
        inventory = i;
        monetizer = m;

        states = new HashMap<>();
        states.put(StatesEnum.IDLE, new Idle(inventory));
        states.put(StatesEnum.SELECTED, new Selected(monetizer));
        states.put(StatesEnum.MONEY_RECEIVED, new MoneyReceived(inventory));
        currentState = states.get(StatesEnum.IDLE);
    }

//    public static synchronized VendingMachine getInstance(Inventory i, Monetizer m) {
//        if(v==null) {
//            v = new VendingMachine(i, m);
//        }
//        return v;
//    }

    public synchronized void selectProduct(String sku) {
//        try {
//            Random rand = new Random();
//            Thread.sleep(rand.nextInt(500));
//        } catch (InterruptedException e) {
//            throw new RuntimeException(e);
//        }
        StatesEnum next = currentState.selectProduct(sku);
        if(!next.equals(StatesEnum.STATE_UNSPECIFIED)) {
            changeState(states.get(next));
            currentSelected = sku;
        }
    }

    public synchronized void collectMoney(Denomination d, int q) {
//        try {
//            Random rand = new Random();
//            Thread.sleep(rand.nextInt(500));
//        } catch (InterruptedException e) {
//            throw new RuntimeException(e);
//        }
        StatesEnum next = currentState.collectMoney(d, q);
        if(!next.equals(StatesEnum.STATE_UNSPECIFIED)) {
            changeState(states.get(next));
            dispatch();
        }

    }

    public synchronized void changeState(State s) {
        currentState = s;
    }

    private void dispatch() {
        StatesEnum next = currentState.dispatch(currentSelected);
        if(!next.equals(StatesEnum.STATE_UNSPECIFIED)) {
            changeState(states.get(next));
        }
    }

    public void showBalance() {
        monetizer.showBalance();
    }

    public void display() {
        StatesEnum next = currentState.display();
        if(!next.equals(StatesEnum.STATE_UNSPECIFIED)) {
            changeState(states.get(next));
        }
    }


}
