package com.waterball.ch2.chain_of_responsibility.handler;

import com.waterball.ch2.chain_of_responsibility.Fire;
import com.waterball.ch2.chain_of_responsibility.Hero;
import com.waterball.ch2.chain_of_responsibility.Sprite;

public class HeroFireCollisionHandler extends CollisionHandler {

    public HeroFireCollisionHandler(CollisionHandler next) {
        super(next);
    }

    @Override
    protected void handleCollision(int x1, int x2, Sprite[] sprites) {
        Sprite c1 = sprites[x1];
        Sprite c2 = sprites[x2];


        if (c1 instanceof Hero && c2 instanceof Fire) {
            System.out.println("Collision between hero and fire. Hero is attacked.");
            Hero hero = (Hero) c1;
            hero.attack(10);

            sprites[x1] = null;

            if (hero.isDead()) {
                sprites[x2] = null;
                System.out.println("Hero is dead.");
            } else {
                sprites[x2] = c1;
                System.out.println(String.format("Hero moves to %s", x2));
            }
        } else if (c1 instanceof Fire && c2 instanceof Hero) {
            System.out.println("Collision between hero and fire. Hero is attacked.");
            Hero hero = (Hero) c2;
            hero.attack(10);

            sprites[x1] = null;

            if (hero.isDead()) {
                sprites[x2] = null;
                System.out.println("Hero is dead.");
            }
        }
    }
}
