package com.waterball.ch2.template_method.uno;

import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
public class Hand {

    private final List<Card> cards = new ArrayList<>();


    public void addCard(Card card) {
        cards.add(card);
    }

    public Card show(int i) {
        return cards.remove(i);
    }

}
