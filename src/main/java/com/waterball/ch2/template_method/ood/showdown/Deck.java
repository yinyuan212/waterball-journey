package com.waterball.ch2.template_method.ood.showdown;

public class Deck extends com.waterball.ch2.template_method.ood.base.Deck {

    public static Deck init52Cards() {
        Deck deck = new Deck();
        for (ShowdownCard.Suit suit : ShowdownCard.Suit.values()) {
            for (ShowdownCard.Rank rank : ShowdownCard.Rank.values()) {
                deck.cardStack.push(new ShowdownCard(suit, rank));
            }
        }
        return deck;
    }
}
