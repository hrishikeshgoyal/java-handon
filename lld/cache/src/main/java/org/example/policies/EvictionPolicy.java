package org.vendingmachine.policies;

public interface EvictionPolicy {
    void markAccessed(int k);
    int evictKey();
}
