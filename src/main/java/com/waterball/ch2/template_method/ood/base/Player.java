package com.waterball.ch2.template_method.ood.base;

import lombok.Data;

@Data
public abstract class Player<Card> {

    private String name;
    private Hand<Card> Hand = new Hand<>();

    public abstract void nameHimself(int i);

    public void addHand(Card card) {
        Hand.addCard(card);
    }



}
