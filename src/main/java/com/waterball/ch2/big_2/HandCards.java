package com.waterball.ch2.big_2;

import java.util.ArrayList;
import java.util.List;

public class HandCards {
    private List<Card> cards = new ArrayList<>();

    public void addCard(Card card) {
        cards.add(card);
    }

    public List<Card> getCards() {
        return cards;
    }

    public boolean hasClubThree() {
        return cards.stream().anyMatch(card -> card.getRank() == Card.Rank.R3 && card.getSuit() == Card.Suit.CLUB);
    }

    public boolean isEmpty() {
        return cards.isEmpty();
    }
}
