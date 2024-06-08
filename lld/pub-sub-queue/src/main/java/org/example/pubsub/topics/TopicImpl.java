package org.vendingmachine.pubsub.topics;

import org.vendingmachine.pubsub.subscribers.Subscriber;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class TopicImpl implements Topic{
    String name;
    private List<String> messages;
    private Map<String, Subscriber> subscribers;

    public TopicImpl(String name) {
        this.name = name;
        messages = new ArrayList<>();
        subscribers = new HashMap<>();
    }
    @Override
    public void publish(String message) {
//        System.out.printf("inside topic publish(), topic: %s, message: %s\n", name, message);
        messages.add(message);
    }

    @Override
    public void addSubscriber(Subscriber subscriber) {
//        System.out.printf("inside topic addSubscriber(), topic: %s, subscriber: %s\n", name, subscriber.getId());
        subscribers.put(subscriber.getId(), subscriber);
    }

    @Override
    public void removeSubscriber(Subscriber subscriber) {
        subscribers.remove(subscriber.getId());
    }

    public List<Subscriber> getSubscribers() {
        return subscribers.values().stream().collect(Collectors.toList());
    }

    @Override
    public List<String> getMessages() {
        return messages;
    }

    @Override
    public String getName() {
        return name;
    }


}
