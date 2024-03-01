package com.waterball.ch2.template_method.ood.showdown;

import com.waterball.ch2.template_method.ood.base.Card;


public abstract class Player extends com.waterball.ch2.template_method.ood.base.Player<Card> {

    private int point;

    public Player() {
        super();
        point = 0;
    }

    public abstract void nameHimself(int i);

    public abstract Card showCard();


    public void gainPoint() {
        point++;
    }

    public int getPoint() {
        return point;
    }
}
