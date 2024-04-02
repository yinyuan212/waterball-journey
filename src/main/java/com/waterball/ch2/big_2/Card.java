package com.waterball.ch2.big_2;

import java.util.HashMap;
import java.util.Map;

public class Card {

    private Rank rank;

    private Suit suit;

    public Card (Suit suit, Rank rank) {
        this.suit = suit;
        this.rank = rank;
    }

    public Rank getRank() {
        return rank;
    }

    public Suit getSuit() {
        return suit;
    }

    @Override
    public String toString() {
        return String.format("%s[%s]", suit.getRepresentation(), rank.getRepresentation());
    }

    public enum Suit {
        SPADE('S'),
        HEART('H'),
        DIAMOND('D'),
        CLUB('C');

        private final char representation;
        private static final Map<Character, Integer> orderMap = new HashMap<>();

        static {
            orderMap.put('S', 4);
            orderMap.put('H', 3);
            orderMap.put('D', 2);
            orderMap.put('C', 1);
        }

        Suit(char representation) {
            this.representation = representation;
        }

        public int getOrder() {
            return orderMap.get(representation);
        }

        public char getRepresentation() {
            return representation;
        }

        public static Suit fromRepresentation(char representation) {
            for (Suit suit : Suit.values()) {
                if (suit.getRepresentation() == representation) {
                    return suit;
                }
            }
            return null;
        }

    }

    public enum Rank {
        R3("3"),
        R4("4"),
        R5("5"),
        R6("6"),
        R7("7"),
        R8("8"),
        R9("9"),
        R10("10"),
        JACK("J"),
        QUEEN("Q"),
        KING("K"),
        ACE("A"),
        R2("2");


        private String representation;

        private Rank(String representation) {
            this.representation = representation;
        }

        public String getRepresentation() {
            return representation;
        }

        public static Rank fromRepresentation(String representation) {
            for (Rank rank : Rank.values()) {
                if (rank.getRepresentation().equals(representation)) {
                    return rank;
                }
            }
            return null;
        }
    }


}
