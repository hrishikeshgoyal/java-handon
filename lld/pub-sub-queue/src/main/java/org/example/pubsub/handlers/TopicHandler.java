package org.vendingmachine.pubsub.handlers;

import org.vendingmachine.pubsub.subscribers.Subscriber;
import org.vendingmachine.pubsub.topics.Topic;

import java.util.HashMap;
import java.util.Map;

public class TopicHandler {
    Topic topic;

    Map<String, SubscriberWorker> workers;

    public TopicHandler(Topic topic) {
        System.out.println("Creating Topic handler for: " + topic.getName());
        this.topic = topic;
        workers = new HashMap<>();
    }

    public void publish(String message) {
//        System.out.printf("Inside topicHandler publish for topic: %s, message: %s \n", topic.getName(), message);
        topic.publish(message);
        workers.values().stream().forEach(w -> w.wakeup());
    }

    public void subscribe(Subscriber s) {
        topic.addSubscriber(s);
        if(!workers.containsKey(s.getId())) {
            workers.put(s.getId(), new SubscriberWorker(s, topic));
            new Thread(() -> workers.get(s.getId()).run()).start();
        }
    }
}
