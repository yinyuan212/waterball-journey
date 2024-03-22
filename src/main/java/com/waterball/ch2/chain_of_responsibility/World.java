package com.waterball.ch2.chain_of_responsibility;

import com.waterball.ch2.chain_of_responsibility.handler.CollisionHandler;

public class World {

    private final Sprite[] sprites;
    private final CollisionHandler collisionHandler;
    private static final int MAX_SPRITES = 30;

    public World(CollisionHandler collisionHandler) {
        sprites = new Sprite[MAX_SPRITES];
        this.collisionHandler = collisionHandler;
        initializeSprites(10);
    }

    public void handle(int x1, int x2) {
        collisionHandler.handle(x1, x2, sprites);
    }

    private void initializeSprites(int initialNumberOfSprites) {
        int n = 0;
        while (n < initialNumberOfSprites) {
            int coordX = (int) (Math.random() * MAX_SPRITES);
            if (sprites[coordX] == null) {
                sprites[coordX] = SpriteFactory.createSprite();
                sprites[coordX].setCoordX(coordX);
                n++;
            }
        }
    }

    public void printAllSprites() {
        StringBuilder sbSprite = new StringBuilder();
        StringBuilder sbCoordX = new StringBuilder();
        int x = 0;

        for (Sprite sprite : sprites) {
            if (sprite == null) {
                sbSprite.append(String.format("%4s", "_"));
            } else {
                sbSprite.append(String.format("%4s", sprite));
            }

            sbCoordX.append(String.format("%4s", x++));
        }
        System.out.println("");
        System.out.println(sbSprite);
        System.out.println(sbCoordX);
    }

}
