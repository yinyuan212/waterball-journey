package com.waterball.ch2.chain_of_responsibility.handler;

import com.waterball.ch2.chain_of_responsibility.Hero;
import com.waterball.ch2.chain_of_responsibility.Sprite;
import com.waterball.ch2.chain_of_responsibility.Water;

public class HeroWaterCollisionHandler extends CollisionHandler {

    public HeroWaterCollisionHandler(CollisionHandler next) {
        super(next);
    }

    @Override
    protected void handleCollision(Sprite c1, Sprite c2, int x1, int x2, Sprite[] sprites) {

        if (c1 instanceof Hero && c2 instanceof Water) {
            System.out.println("Collision between hero and water. Hero gains hp.");
            Hero hero = (Hero) c1;
            hero.gainHp(10);

            sprites[x1] = null;
            sprites[x2] = c1;
            System.out.println(String.format("Hero moves to %s", x2));

        } else if (c1 instanceof Water && c2 instanceof Hero) {
            System.out.println("Collision between hero and water. Hero gains hp.");
            Hero hero = (Hero) c2;
            hero.gainHp(10);

            sprites[x1] = null;
        }
    }
}
