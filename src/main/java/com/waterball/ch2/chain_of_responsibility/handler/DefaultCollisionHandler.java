package com.waterball.ch2.chain_of_responsibility.handler;

import com.waterball.ch2.chain_of_responsibility.Sprite;

public class DefaultCollisionHandler extends CollisionHandler {

    public DefaultCollisionHandler(CollisionHandler next) {
        super(next);
    }

    @Override
    protected void handleCollision(int x1, int x2, Sprite[] sprites) {
        Sprite c1 = sprites[x1];
        Sprite c2 = sprites[x2];

        if (c1 != null && c2 == null) {
            System.out.println(String.format("%s moves to %s", c1, x2));
            sprites[x1] = null;
            sprites[x2] = c1;
        }
    }
}
