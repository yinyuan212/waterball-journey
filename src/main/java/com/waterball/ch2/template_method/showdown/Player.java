package com.waterball.ch2.template_method.showdown;

import lombok.Data;

import java.util.List;

@Data
public abstract class Player {

    private String name;
    private Hand hand;
    private int point;

    public Player() {
        hand = new Hand();
        point = 0;
    }

    public abstract void nameHimSelf(int i);

    public void addHand(Card card) {
        List<Card> cards = hand.getCards();
        cards.add(card);
    }

    public abstract Card showCard();

    public void gainPoint() {
        point++;
    }


}
