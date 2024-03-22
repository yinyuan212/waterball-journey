package com.waterball.ch2.chain_of_responsibility.handler;

import com.waterball.ch2.chain_of_responsibility.Sprite;

public class SameSpriteCollisionHandler extends CollisionHandler {
    public SameSpriteCollisionHandler(CollisionHandler next) {
        super(next);
    }

    @Override
    protected void handleCollision(Sprite c1, Sprite c2, int x1, int x2, Sprite[] sprites) {

        if (c1 != null && c2 != null && c1.toString().equals(c2.toString())) {
            System.out.println(String.format("Collision between %s and %s. Nothing happens.", c1, c2));
        }
    }

}
