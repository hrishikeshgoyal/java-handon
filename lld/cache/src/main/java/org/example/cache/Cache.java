package org.vendingmachine.cache;

public interface Cache {
    String get(int k);
    void set(int k, String v);
}
