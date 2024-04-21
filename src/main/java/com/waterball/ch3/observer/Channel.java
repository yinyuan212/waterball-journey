package com.waterball.ch3.observer;

import java.util.ArrayList;
import java.util.List;

public class Channel {

    public Channel(String name) {
        this.name = name;
    }

    private String name;

    private List<Subscriber> subscribers = new ArrayList<>();


    public void register(Subscriber subscriber) {
        subscribers.add(subscriber);
    }

    public void unregister(Subscriber subscriber) {
        subscribers.remove(subscriber);
    }

    public void upload(Video video) {
        System.out.println(String.format("Channel %s uploads a new video: %s", name, video.getTitle()));
        List<Subscriber> copySubscribers = new ArrayList<>(subscribers);
        for (Subscriber subscriber : copySubscribers) {
            subscriber.receiveNotify(this, video);
        }
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
