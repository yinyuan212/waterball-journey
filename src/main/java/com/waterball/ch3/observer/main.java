package com.waterball.ch3.observer;

public class main {

    public static void main(String[] args) {
        Channel waterballSoftwareCollege = new Channel("Waterball Software college");
        Channel pewDiePie = new Channel("PewDiePie");

        WaterballSubscriber waterballSubscriber = new WaterballSubscriber("waterball");
        FireballSubscriber fireballSubscriber = new FireballSubscriber("fireball");

        waterballSubscriber.subscribe(waterballSoftwareCollege);
        waterballSubscriber.subscribe(pewDiePie);
        fireballSubscriber.subscribe(waterballSoftwareCollege);
        fireballSubscriber.subscribe(pewDiePie);

        Video c1M1S2 = new Video("C1M1S2", "這個世界正是物件導向的呢！", 4);
        Video helloGuys = new Video("Hello guys", "Clickbait", 0.5f);
        Video c1M1S3 = new Video("C1M1S3", "物件 vs. 類別", 1);
        Video minecraft = new Video("Minecraft", "Let’s play Minecraft", 30);


        waterballSoftwareCollege.upload(c1M1S2);
        pewDiePie.upload(helloGuys);
        waterballSoftwareCollege.upload(c1M1S3);
        pewDiePie.upload(minecraft);
    }
}
