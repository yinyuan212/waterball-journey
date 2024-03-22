package com.waterball.ch2.chain_of_responsibility.handler;

import com.waterball.ch2.chain_of_responsibility.Fire;
import com.waterball.ch2.chain_of_responsibility.Sprite;
import com.waterball.ch2.chain_of_responsibility.Water;

public class WaterFireCollisionHandler extends CollisionHandler {

    public WaterFireCollisionHandler(CollisionHandler next) {
        super(next);
    }

    @Override
    protected void handleCollision(Sprite c1, Sprite c2, int x1, int x2, Sprite[] sprites) {
        if ((c1 instanceof Water && c2 instanceof Fire) ||
                (c1 instanceof Fire && c2 instanceof Water)) {
            System.out.println("Collision between water and fire. Water and fire are destroyed.");
            sprites[x1] = null;
            sprites[x2] = null;
        }
    }
}
