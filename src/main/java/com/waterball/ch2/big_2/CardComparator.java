package com.waterball.ch2.big_2;

import java.util.Comparator;

public class CardComparator implements Comparator<Card> {
    @Override
    public int compare(Card card1, Card card2) {
        // 比较点数
        int rankComparison = Integer.compare(card1.getRank().ordinal(), card2.getRank().ordinal());
        if (rankComparison != 0) {
            return rankComparison;
        }
        // 如果点数相同，则比较花色
        return Integer.compare(card1.getSuit().getOrder(), card2.getSuit().getOrder());
    }
}