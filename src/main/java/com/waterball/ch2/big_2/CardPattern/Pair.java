package com.waterball.ch2.big_2.CardPattern;

import com.waterball.ch2.big_2.Card;
import com.waterball.ch2.big_2.CardPattern.CardPattern;

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
    protected int getKeyCardIndex() {
        return 1;
    }

}
