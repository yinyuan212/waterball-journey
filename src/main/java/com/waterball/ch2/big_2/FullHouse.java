package com.waterball.ch2.big_2;

import java.util.List;

public class FullHouse extends CardPattern {
    public FullHouse(CardPattern next) {
        super(next);
    }

    @Override
    public String getCardPatternName(List<Card> cards) {
        return null;
    }

    @Override
    public boolean compare(List<Card> cards1, List<Card> cards2) {
        return true;
    }


}
