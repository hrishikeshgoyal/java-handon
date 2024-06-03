package org.example;

import org.example.pubsub.subscribers.Subscriber;
import org.example.pubsub.subscribers.SubscriberImpl;
import org.example.pubsub.topics.Topic;

public class Main {
    public static void main(String[] args) {
        Queue q = new Queue();

        Topic t1 = q.createTopic("t1");

        Topic t3 = q.createTopic("t3");

        Subscriber s1 = new SubscriberImpl("c1", 1);
        Subscriber s2 = new SubscriberImpl("c2", 2);

        Subscriber s3 = new SubscriberImpl("c3", 2);

        q.subscribe(t1, s1);
        q.subscribe(t3, s3);
        q.subscribe(t1, s2);
        q.subscribe(t3, s2);

        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        q.publish(t1, "Hi");
        q.publish(t3, "Hello");
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        q.publish(t1, " Hello T1");
        q.publish(t3, " Hello T3");

    }
}