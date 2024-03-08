package com.waterball.ch2.template_method.uno;

import lombok.Data;

import java.util.Collections;
import java.util.List;
import java.util.Stack;

@Data
public class Deck {

    private final Stack<Card> cardStack = new Stack<>();

    public Deck() {
        init40Cards();
    }

    public void init40Cards() {
        for (Card.Color color : Card.Color.values()) {
            for (int i = 0; i < 10; i++) {
                cardStack.add(new Card(color, i));
            }
        }
    }

    public void shuffle() {
        Collections.shuffle(cardStack);
    }

    public Card drawCard() {
        return cardStack.pop();
    }

    public void shuffleUsedCards(List<Card> usedCards) {
        for (Card card : usedCards) {
            cardStack.add(card);
        }
        shuffle();
    }


}
