package com.waterball.ch2.template_method.ood.showdown;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = false)
public class ShowdownCard extends com.waterball.ch2.template_method.ood.base.Card {

    private Suit suit;
    private Rank rank;

    public ShowdownCard(Suit suit, Rank rank) {
        this.suit = suit;
        this.rank = rank;
    }

    public enum Suit {
        SPADE('♠'),
        HEART('♥'),
        DIAMOND('♦'),
        CLUB('♣');

        private final char representation;

        Suit(char representation) {
            this.representation = representation;
        }

    }

    public enum Rank {
        TWO(2),
        THREE(3),
        FOUR(4),
        FIVE(5),
        SIX(6),
        SEVEN(7),
        EIGHT(8),
        NINE(9),
        TEN(10),
        JACK(11),
        QUEEN(12),
        KING(13),
        ACE(14);

        private int value;

        private Rank(int value) {
            this.value = value;
        }

        public int getValue() {
            return value;
        }
    }

    public boolean isBiggerThan(ShowdownCard other) {
        if (this.getRank() == other.getRank()) {
            return this.getSuit().representation > other.getSuit().representation;
        }

        return this.getRank().getValue() > other.getRank().getValue();
    }

    @Override
    public String toString() {
        return String.format("%s:%d", suit, rank.getValue());
    }
}
