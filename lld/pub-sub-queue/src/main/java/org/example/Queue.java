package org.example;

import org.example.pubsub.handlers.TopicHandler;
import org.example.pubsub.subscribers.Subscriber;
import org.example.pubsub.topics.Topic;
import org.example.pubsub.topics.TopicImpl;

import java.util.HashMap;
import java.util.Map;

public class Queue {
    Map<String, TopicHandler> handlers;

    public Queue() {
        handlers = new HashMap<>();
    }
    public Topic createTopic(String name) {
        System.out.println("creating topic: "+name);
        Topic t = new TopicImpl(name);
        if(!handlers.containsKey(t.getName())) {
            handlers.put(t.getName(), new TopicHandler(t));
        }
        return t;
    }

    public void publish(Topic t, String message) {
        handlers.get(t.getName()).publish(message);
    }

    public void subscribe(Topic t, Subscriber s) {
        handlers.get(t.getName()).subscribe(s);
    }

}
