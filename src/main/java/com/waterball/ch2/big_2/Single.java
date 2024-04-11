package com.waterball.ch2.big_2;

import java.util.List;

public class Single extends CardPattern{
    public Single(CardPattern next) {
        super(next);
    }

    @Override
    protected String getPatternName(List<Card> cardsToPlay) {
        if (cardsToPlay.size() == 1) {
            return "Single";
        }

        return "";
    }

    @Override
    public boolean compare(List<Card> cardsToPlay, List<Card> topPlay) {

        // 第一輪的情境
        if (topPlay == null && cardsToPlay.size() == 1) {
            // 判斷cardsToPlay是否符合single牌型
            return true;
        }

        if (cardsToPlay.size() == 1 && topPlay.size() == 1) {
            Card ctp = cardsToPlay.get(0);
            Card tp = topPlay.get(0);

            int rankComparison = Integer.compare(ctp.getRank().ordinal(), tp.getRank().ordinal());

            // 如果点数相同，则比较花色
            if (rankComparison == 0) {
                int suitComparison = Integer.compare(ctp.getSuit().getOrder(), tp.getSuit().getOrder());
                if (suitComparison < 0) {
                    return false;
                } else {
                    return true;
                }
            } else if (rankComparison < 0) {
                return false;
            } else {
                return true;
            }
        }

        return false;
    }
}
