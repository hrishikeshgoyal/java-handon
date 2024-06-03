package org.example;

import org.example.cache.Cache;
import org.example.cache.LRUCache;
import org.example.policies.EvictionPolicy;
import org.example.policies.LruEvictionPolicy;
import org.example.store.DataStore;
import org.example.store.InMemoryHashMap;

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