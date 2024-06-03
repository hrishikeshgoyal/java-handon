package org.example.cache;

import org.example.policies.EvictionPolicy;
import org.example.store.DataStore;

public class LRUCache implements Cache{
    private EvictionPolicy policy;
    private DataStore store;

    public LRUCache(EvictionPolicy policy, DataStore store) {
        this.policy = policy;
        this.store = store;
    }
    @Override
    public String get(int k) {
        String v = store.get(k);
        policy.markAccessed(k);
        return v;
    }

    @Override
    public void set(int k, String v) {
        try {
            store.set(k, v);
        }catch (IllegalStateException e) {
            int keyToEvict = policy.evictKey();
            System.out.println("Evicting: "+ keyToEvict);
            store.remove(keyToEvict);
            store.set(k, v);
        }
        policy.markAccessed(k);
    }
}
