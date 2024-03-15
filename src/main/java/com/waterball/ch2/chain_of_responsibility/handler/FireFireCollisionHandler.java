package com.waterball.ch2.chain_of_responsibility.handler;

import com.waterball.ch2.chain_of_responsibility.Fire;
import com.waterball.ch2.chain_of_responsibility.Sprite;

public class FireFireCollisionHandler extends CollisionHandler {

    public FireFireCollisionHandler(CollisionHandler next) {
        super(next);
    }

    @Override
    protected void handleCollision(int x1, int x2, Sprite[] sprites) {
        Sprite c1 = sprites[x1];
        Sprite c2 = sprites[x2];
        if ((c1 instanceof Fire && c2 instanceof Fire)) {
            System.out.println("Collision between fire and fire. Nothing happens.");
        }
    }
}
