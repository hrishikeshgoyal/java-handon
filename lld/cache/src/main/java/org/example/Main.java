package org.vendingmachine;

import org.vendingmachine.cache.Cache;
import org.vendingmachine.cache.LRUCache;
import org.vendingmachine.policies.EvictionPolicy;
import org.vendingmachine.policies.LruEvictionPolicy;
import org.vendingmachine.store.DataStore;
import org.vendingmachine.store.InMemoryHashMap;

public class Main {
    public static void main(String[] args) {

        DataStore d = new InMemoryHashMap(5);
        EvictionPolicy p = new LruEvictionPolicy();

        Cache c = new LRUCache(p, d);
        c.set(1,"AB");
        c.set(2,"AB");
        c.set(3,"AB");
        c.set(4,"AB");
        c.set(5,"AB");
        c.set(1,"AB");
        c.set(6,"AB");

    }
}