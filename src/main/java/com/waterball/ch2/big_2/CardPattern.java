package com.waterball.ch2.big_2;



import java.util.List;

public abstract class CardPattern {

    private CardPattern next;

    public CardPattern(CardPattern next) {
        this.next = next;
    }


    /**
     * 1. cardsToPlay為空List，代表打pass
     *      1.a. topPlay是null，是第一輪，不能pass
     *      1.b. topPlay不是null，可以pass
     *
     * 2. cardsToPlay是哪種有效牌型
     *      2.a. 是有效牌型，return 牌型名稱
     *      2.b. 不是有效牌型，用下一個handler判斷
     *
     * 3. topPlay跟cardsToPlay是一樣的牌型嗎
 *          3.a. topPlay的牌型(由參數傳入)是空字串
     *          3.a.1. cardsToPlay變成頂牌
 *          3.b. topPlay的牌型(由參數傳入)不是空字串
     *          3.b.1 topPlay跟cardsToPlay是一樣牌型，比較大小
     *          3.b.2 topPlay跟cardsToPlay不是一樣牌型，用下一個handler判斷
     * 4. 都不是有效牌型，重打
     *
     */
    public CardPatternResult handle(int round, List<Card> cardsToPlay, List<Card> topPlay, String topPlayPatternName) {



        CardPatternResult cardPatternResult = new CardPatternResult();
        cardPatternResult.setTopPlay(topPlay);

        // 第一回合的第一輪，一定要打梅花3
        if (round == 1 && topPlay == null && !cardsToPlay.stream().anyMatch(card -> card.getRank() == Card.Rank.R3 && card.getSuit() == Card.Suit.CLUB)) {
            cardPatternResult.setResult("REPLAY");
            return cardPatternResult;
        }

        if (cardsToPlay.isEmpty()) {
            // 不能pass的情境
            if (topPlay == null) {
                cardPatternResult.setResult("REPLAY");
                return cardPatternResult;
            // 可以pass的情境
            } else {
                cardPatternResult.setResult("PASS");
                return cardPatternResult;
            }
        }

        // cardsToPlay非有效牌型，
        String cardsToPlayPatternName = getPatternName(cardsToPlay);
        if ("".equals(cardsToPlayPatternName)) {
            if (next != null) {
                return next.handle(round, cardsToPlay, topPlay, topPlayPatternName);
            }
        }

        if ("".equals(topPlayPatternName)) {
            cardPatternResult.setTopPlayName(cardsToPlayPatternName);
            cardPatternResult.setTopPlay(cardsToPlay);
            cardPatternResult.setResult("carsToPlay_WIN");
            return cardPatternResult;
        } else if (cardsToPlayPatternName.equals(topPlayPatternName)) {
            if(compare(cardsToPlay, topPlay)) {
                cardPatternResult.setTopPlayName(cardsToPlayPatternName);
                cardPatternResult.setTopPlay(cardsToPlay);
                cardPatternResult.setResult("carsToPlay_WIN");
                return cardPatternResult;
            } else {
                cardPatternResult.setResult("REPLAY");
                return cardPatternResult;
            }
        } else if (next != null) {
            return next.handle(round, cardsToPlay, topPlay, topPlayPatternName);
        }

        cardPatternResult.setResult("REPLAY");
        return cardPatternResult;
    }

    /**
     * 如果cardsToPlay是此handler牌型，回傳牌型名稱，否則回傳空字串
     * @param cardsToPlay
     * @return
     */
    protected abstract String getPatternName(List<Card> cardsToPlay);

    public abstract boolean compare(List<Card> cardsToPlay, List<Card> topPlay);


}
