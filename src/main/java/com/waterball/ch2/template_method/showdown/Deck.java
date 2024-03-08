package com.waterball.ch2.template_method.showdown;

import java.util.Collections;
import java.util.Stack;

public class Deck {

    private final Stack<Card> cardStack = new Stack<>();

    public static Deck init52Cards() {
        Deck deck = new Deck();
        for (Card.Suit suit : Card.Suit.values()) {
            for (Card.Rank rank : Card.Rank.values()) {
                deck.cardStack.push(new Card(suit, rank));
            }
        }
        return deck;
    }

    public void shuffle() {
        Collections.shuffle(cardStack);
    }

    public Card drawCard() {
        return cardStack.pop();
    }
}
