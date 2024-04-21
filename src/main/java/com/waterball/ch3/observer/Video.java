package com.waterball.ch3.observer;

public class Video {

    private String title;
    private String description;
    private float length;

    public Video(String title, String description, float length) {
        this.title = title;
        this.description = description;
        this.length = length;
    }

    public String getTitle() {
        return title;
    }

    public float getLength() {
        return length;
    }
}
