package org.vendingmachine.pubsub.topics;

import org.vendingmachine.pubsub.subscribers.Subscriber;

import java.util.List;

public interface Topic {
    void publish(String message);
    void addSubscriber(Subscriber subscriber);
    void removeSubscriber(Subscriber subscriber);

    List<Subscriber> getSubscribers();

    List<String> getMessages();
    String getName();

}
