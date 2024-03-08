package com.waterball.ch2.template_method.ood.showdown;



public abstract class Player extends com.waterball.ch2.template_method.ood.base.Player<ShowdownCard> { // 實作層，在原本泛型的位置，放入實際要用的class

    private int point;

    public Player() {
        super();
        point = 0;
    }

    public abstract void nameHimself(int i);

    public abstract ShowdownCard showCard();


    public void gainPoint() {
        point++;
    }

    public int getPoint() {
        return point;
    }
}
