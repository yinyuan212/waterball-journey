package com.waterball.ch2.big_2;

import java.util.List;

public class Pair extends CardPattern {

    public Pair(CardPattern next) {
        super(next);
    }

    @Override
    protected String getPatternName(List<Card> cardsToPlay) {
        if (cardsToPlay.size() == 2 &&
        cardsToPlay.get(0).getRank().ordinal() == cardsToPlay.get(1).getRank().ordinal()) {
            return "Pair";
        }

        return "";
    }


    @Override
    public boolean compare(List<Card> cardsToPlay, List<Card> topPlay) {
        return true;
    }


}
