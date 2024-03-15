package com.waterball.ch2.chain_of_responsibility;

public class SpriteFactory {

    public static Sprite createSprite() {
        int rand = (int) (Math.random() * 3);
        switch (rand) {
            case 0:
                return new Water();
            case 1:
                return new Fire();
            case 2:
                return new Hero();
            default:
                return null;
        }
    }
}
