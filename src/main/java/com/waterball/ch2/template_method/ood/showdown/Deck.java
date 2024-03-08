package com.waterball.ch2.template_method.ood.showdown;

public class Deck extends com.waterball.ch2.template_method.ood.base.Deck<ShowdownCard> { // 實作層，在原本泛型的位置，放入實際要用的class

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
