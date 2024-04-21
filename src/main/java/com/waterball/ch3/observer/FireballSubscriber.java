package com.waterball.ch3.observer;

public class FireballSubscriber extends Subscriber {

    public FireballSubscriber(String name) {
        super(name);
    }

    @Override
    protected void receiveNotify(Channel channel, Video video) {
        if (video.getLength() <= 1) {
            unsubscribe(channel);
        }
    }
}
