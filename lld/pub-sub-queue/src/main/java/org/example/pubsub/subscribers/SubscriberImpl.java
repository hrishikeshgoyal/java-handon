package org.vendingmachine.pubsub.subscribers;

public class SubscriberImpl implements Subscriber{

    String id;
    int waitTime;

    public SubscriberImpl(String id, int waitTime) {
        System.out.println("Creating Subscriber: " + id);
        this.id = id;
        this.waitTime = waitTime;
    }
    @Override
    public String getId() {
        return id;
    }

    @Override
    public void consume(String mes) throws InterruptedException {
        System.out.println("I am subscriber: "+ id + " and consuming: "+mes);
        Thread.sleep(waitTime  *1000);
    }
}
