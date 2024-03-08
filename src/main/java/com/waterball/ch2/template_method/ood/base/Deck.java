package com.waterball.ch2.template_method.ood.base;

import java.util.Collections;
import java.util.Stack;

public class Deck<Card> {

    protected final Stack<Card> cardStack = new Stack<>();

    public void shuffle() {
        Collections.shuffle(cardStack);
    }

    public Card drawCard() {
        return cardStack.pop();
    }

    public Stack<Card> getCardStack() {
        return cardStack;
    }
}
