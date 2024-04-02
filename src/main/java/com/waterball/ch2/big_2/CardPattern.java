package com.waterball.ch2.big_2;

import java.util.List;

public abstract class CardPattern {

    private CardPattern next;

    public CardPattern(CardPattern next) {
        this.next = next;
    }

    /**
     * 1. topPlay是什麼牌型
     * 2. cardsToPlay的牌型是否跟topPlay一樣
     * 3. cardsToPlay是否大於topPlay
     *        3.1 一cardsToPlay大於topPlay，回傳true
     *        3.2 一cardsToPlay小於topPlay，回傳false
     */
    public boolean isCardsToPlayBiggerThanTopPay(int round, int playerIndex, List<Card> topPlay, List<Card> cardsToPlay) {

        String topPlayPattern = getCardPatternName(topPlay);
        String cardsToPlayPattern = getCardPatternName(cardsToPlay);

        if (canHandle(topPlayPattern, cardsToPlayPattern)) {
            if (compare(topPlay, cardsToPlay)) {
                return true;
            }

            next.isCardsToPlayBiggerThanTopPay(round, playerIndex, topPlay, cardsToPlay);
        }
        return false;
    }

    public abstract String getCardPatternName(List<Card> cards);

    public boolean canHandle(String topPlayPattern, String cardsToPlayPattern) {
        return "ALL-ALLOWED".equals(topPlayPattern) || topPlayPattern.equals(cardsToPlayPattern);
    }

    public abstract boolean compare(List<Card> cards1, List<Card> cards2);

}
