package com.waterball.ch2.chain_of_responsibility.handler;

import com.waterball.ch2.chain_of_responsibility.Sprite;

public abstract class CollisionHandler {
    protected CollisionHandler next;

    public CollisionHandler(CollisionHandler next) {
        this.next = next;
    }

    public void handle(int x1, int x2, Sprite[] sprites) {
        handleCollision(x1, x2, sprites);

        if (next != null) {
            next.handle(x1, x2, sprites);
        }
    }

    protected abstract void handleCollision(int x1, int x2, Sprite[] sprites);
}
