package com.waterball.ch2.big_2.CardPattern;

import com.waterball.ch2.big_2.Card;
import com.waterball.ch2.big_2.CardPattern.CardPattern;

import java.util.List;

public class Single extends CardPattern {
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
    protected int getKeyCardIndex() {
        return 0;
    }
}
