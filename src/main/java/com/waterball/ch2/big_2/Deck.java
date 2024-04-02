package com.waterball.ch2.big_2;

import java.util.Collections;
import java.util.Scanner;
import java.util.Stack;

public class Deck {

    private Stack<Card> cardStack = new Stack<>();


    public void init52Cards() {
        Scanner scanner = new Scanner(System.in, "UTF-8");
        String line = scanner.nextLine();
        String[] cards = line.split(" ");

        for (String s : cards) {
            char suit = s.substring(0, 1).charAt(0);

            int left = s.indexOf("[");
            int right = s.indexOf("]");
            String rank = s.substring(left + 1, right);


            Card card = new Card(Card.Suit.fromRepresentation(suit), Card.Rank.fromRepresentation(rank));
            cardStack.push(card);
        }
    }

    public Card deal() {
        return cardStack.pop();
    }

    public void shuffle() {
        Collections.shuffle(cardStack);
    }

    public boolean isEmpty() {
        return cardStack.isEmpty();
    }
}
