package com.waterball.ch2.big_2.CardPattern;

import com.waterball.ch2.big_2.Card;
import com.waterball.ch2.big_2.CardPattern.CardPattern;

import java.util.List;

public class Straight extends CardPattern {

    public Straight(CardPattern next) {
        super(next);
    }

    @Override
    protected String getPatternName(List<Card> cardsToPlay) {
        if (cardsToPlay.size() == 5 &&
        cardsToPlay.get(4).getRank().ordinal() - cardsToPlay.get(3).getRank().ordinal() == 1 &&
        cardsToPlay.get(3).getRank().ordinal() - cardsToPlay.get(2).getRank().ordinal() == 1 &&
        cardsToPlay.get(2).getRank().ordinal() - cardsToPlay.get(1).getRank().ordinal() == 1 &&
        cardsToPlay.get(1).getRank().ordinal() - cardsToPlay.get(0).getRank().ordinal() == 1) {
            return "Straight";
        }

        return "";
    }

    @Override
    protected int getKeyCardIndex() {
        return 4;
    }
}
