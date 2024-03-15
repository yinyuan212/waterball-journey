package com.waterball.ch2.chain_of_responsibility.handler;

import com.waterball.ch2.chain_of_responsibility.Sprite;
import com.waterball.ch2.chain_of_responsibility.Water;

public class WaterWaterCollisionHandler extends CollisionHandler {
    public WaterWaterCollisionHandler(CollisionHandler next) {
        super(next);
    }

    @Override
    protected void handleCollision(int x1, int x2, Sprite[] sprites) {
        Sprite c1 = sprites[x1];
        Sprite c2 = sprites[x2];
        if ((c1 instanceof Water && c2 instanceof Water)) {
            System.out.println("Collision between water and water. Nothing happens.");
        }
    }
}
