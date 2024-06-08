package org.vendingmachine.pubsub.subscribers;

public interface Subscriber {
    String getId();
    void consume(String mes) throws InterruptedException;
}
