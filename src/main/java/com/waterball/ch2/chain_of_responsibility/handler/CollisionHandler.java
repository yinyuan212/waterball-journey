package com.waterball.ch2.chain_of_responsibility.handler;

import com.waterball.ch2.chain_of_responsibility.Sprite;

public abstract class CollisionHandler {
    protected CollisionHandler next;

    public CollisionHandler(CollisionHandler next) {
        this.next = next;
    }

    public void handle(int x1, int x2, Sprite[] sprites) {
        Sprite c1 = sprites[x1];
        Sprite c2 = sprites[x2];

        handleCollision(c1, c2, x1, x2, sprites);

        if (next != null) {
            next.handle(x1, x2, sprites);
        }
    }

    protected abstract void handleCollision(Sprite c1, Sprite c2, int x1, int x2, Sprite[] sprites);



}
