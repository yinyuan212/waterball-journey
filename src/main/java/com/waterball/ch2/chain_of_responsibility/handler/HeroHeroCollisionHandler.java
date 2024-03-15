package com.waterball.ch2.chain_of_responsibility.handler;

import com.waterball.ch2.chain_of_responsibility.Hero;
import com.waterball.ch2.chain_of_responsibility.Sprite;

public class HeroHeroCollisionHandler extends CollisionHandler {

    public HeroHeroCollisionHandler(CollisionHandler next) {
        super(next);
    }

    @Override
    protected void handleCollision(int x1, int x2, Sprite[] sprites) {
        Sprite c1 = sprites[x1];
        Sprite c2 = sprites[x2];

        if (c1 instanceof Hero && c2 instanceof Hero) {
            System.out.println("Collision between hero and hero. Nothing happens.");
        }
    }
}
