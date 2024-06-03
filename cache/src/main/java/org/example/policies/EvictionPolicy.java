package org.example.policies;

public interface EvictionPolicy {
    void markAccessed(int k);
    int evictKey();
}
