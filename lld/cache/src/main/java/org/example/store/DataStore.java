package org.vendingmachine.store;

public interface DataStore {
    void set(int k, String v);
    void remove(int k);

    String get(int k);
}
