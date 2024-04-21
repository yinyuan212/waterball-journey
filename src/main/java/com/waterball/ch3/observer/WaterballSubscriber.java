package com.waterball.ch3.observer;

public class WaterballSubscriber extends Subscriber {

    public WaterballSubscriber(String name) {
        super(name);
    }

    @Override
    protected void receiveNotify(Channel channel, Video video) {
        if (video.getLength() >= 3) {
            like(video);
        }
    }

    private void like(Video video) {
        System.out.println(String.format("%s likes a new video: %s", getName(), video.getTitle()));
    }
}
