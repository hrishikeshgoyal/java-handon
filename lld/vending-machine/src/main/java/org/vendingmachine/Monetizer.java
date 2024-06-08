package org.vendingmachine;

import java.sql.SQLOutput;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class Monetizer {
    Map<Denomination, Integer> balance = new ConcurrentHashMap<>();
    public int showBalance() {
        int amount = 0;
        for (var e : balance.entrySet()) {
            amount += e.getKey().val * e.getValue();
        }
        System.out.println("Current balance in vending machine is: " + amount);
        return amount;
    }
    public void deposit(Denomination d, int q) {
        balance.putIfAbsent(d, 0);
        balance.put(d, balance.get(d) + q);
    }

}
