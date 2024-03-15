package com.waterball.ch2.chain_of_responsibility;

public class Hero extends Sprite {
    private int hp;

    public Hero() {
        this.hp = 30;
    }

    public void attack(int damage) {
        hp -= damage;
    }

    public void gainHp(int hp) {
        this.hp += hp;
    }

    public boolean isDead() {
        return hp <= 0;
    }

    @Override
    public String toString() {
        return "H";
    }
}
