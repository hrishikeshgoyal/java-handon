package org.vendingmachine.pubsub.handlers;

import org.vendingmachine.pubsub.subscribers.Subscriber;
import org.vendingmachine.pubsub.topics.Topic;

public class SubscriberWorker {

    private Subscriber subscriber;
    private Topic topic;

    private int offset;

    SubscriberWorker(Subscriber s, Topic t) {
        subscriber = s;
        topic = t;
        offset = 0;
    }

//    @Override
    public void run() {
        synchronized (subscriber) {
//            System.out.printf("worker run(), topic: %s, subscriber: %s\n", topic.getName(), subscriber.getId());
            while (true) {
//                System.out.printf("    while, topic: %s, subscriber: %s\n", topic.getName(), subscriber.getId());
                try {
                    if (offset >= topic.getMessages().size()) {
//                        System.out.printf("        wait(), topic: %s, subscriber: %s\n", topic.getName(), subscriber.getId());
                        subscriber.wait();
                    }
                    subscriber.consume(topic.getMessages().get(offset++));
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
        }
    }
    synchronized public void wakeup() {
        synchronized (subscriber) {
            subscriber.notify();
        }
    }
}
