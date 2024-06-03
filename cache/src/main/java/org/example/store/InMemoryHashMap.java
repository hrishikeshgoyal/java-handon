package org.example.store;

import java.util.HashMap;
import java.util.Map;

public class InMemoryHashMap implements DataStore{

    private int capacity;
    private Map<Integer, String> map;

    public InMemoryHashMap(int capacity) {
        this.capacity = capacity;
        this.map = new HashMap<Integer, String>();
    }

    @Override
    public String get(int k) {
        return map.get(k);
    }

    @Override
    public void set(int k, String v) {
        if(map.size()>=capacity && !map.containsKey(k)) {
            throw new IllegalStateException("Capacity is full");
        }
        map.put(k, v);
    }

    @Override
    public void remove(int k) {
        map.remove(k);
    }
}
