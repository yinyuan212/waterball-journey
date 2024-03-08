package com.waterball.ch2.template_method.ood.base;

import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
public class Hand<Card> {

    private final List<Card> cards = new ArrayList<>();

    public Card showCard(int i) {
        return cards.remove(i);
    }

    public void addCard(Card card) {
        cards.add(card);
    }
}
