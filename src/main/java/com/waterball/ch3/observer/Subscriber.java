package com.waterball.ch3.observer;

import java.util.ArrayList;
import java.util.List;

public abstract class Subscriber {

    private String name;

    private List<Channel> channels = new ArrayList<>();

    public  Subscriber(String name) {
        this.name = name;
    }

    public void subscribe(Channel channel) {
        channel.register(this);
        channels.add(channel);
        System.out.println(String.format("%s subscribes to channel: %s", name, channel.getName()));
    }

    public void unsubscribe(Channel channel) {
        channel.unregister(this);
        channels.remove(channel);
        System.out.println(String.format("%s unsubscribes from channel: %s", name, channel.getName()));
    }

    protected abstract void receiveNotify(Channel channel, Video video);

    public String getName() {
        return name;
    }
}
