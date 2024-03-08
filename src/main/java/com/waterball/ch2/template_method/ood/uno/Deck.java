package com.waterball.ch2.template_method.ood.uno;

import java.util.List;

public class Deck extends com.waterball.ch2.template_method.ood.base.Deck<UnoCard> { // 實作層，在原本泛型的位置，放入實際要用的class

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
