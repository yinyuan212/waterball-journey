package com.waterball.ch2.template_method.uno;

import lombok.Data;

import java.util.List;

@Data
public abstract class Player {

    private String name;
    private Hand hand;

    public Player() {
        hand = new Hand();
    }

    public abstract void nameHimSelf(int i);

    public void addHand(Card card) {
        hand.addCard(card);
    }

    public abstract Card showCard(Card card);

}
