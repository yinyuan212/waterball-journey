package com.waterball.ch2.big_2;

import java.util.List;

public class FullHouse extends CardPattern {
    public FullHouse(CardPattern next) {
        super(next);
    }

    @Override
    protected String getPatternName(List<Card> cardsToPlay) {
        return null;
    }


    @Override
    public boolean compare(List<Card> cardsToPlay, List<Card> topPlay) {
        return false;
    }


}
