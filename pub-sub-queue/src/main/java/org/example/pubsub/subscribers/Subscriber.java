package org.example.pubsub.subscribers;

public interface Subscriber {
    String getId();
    void consume(String mes) throws InterruptedException;
}
