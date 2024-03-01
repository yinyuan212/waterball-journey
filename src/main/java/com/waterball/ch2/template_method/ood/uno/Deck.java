package com.waterball.ch2.template_method.ood.uno;

import java.util.List;

public class Deck extends com.waterball.ch2.template_method.ood.base.Deck {

    public static Deck init40Cards() {
        Deck deck = new Deck();
        for (UnoCard.Color color : UnoCard.Color.values()) {
            for (int i = 0; i < 10; i++) {
                deck.cardStack.add(new UnoCard(color, i));
            }
        }

        return deck;
    }

    public void shuffleUsedCards(List<UnoCard> usedCards) {
        for (UnoCard card : usedCards) {
            cardStack.add(card);
        }
        shuffle();
    }
}
