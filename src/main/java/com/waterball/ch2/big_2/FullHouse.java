package com.waterball.ch2.big_2;

import java.util.List;

public class FullHouse extends CardPattern {
    public FullHouse(CardPattern next) {
        super(next);
    }

    @Override
    protected String getPatternName(List<Card> cardsToPlay) {
        int rank1 = cardsToPlay.get(0).getRank().ordinal();
        int rank2 = cardsToPlay.get(4).getRank().ordinal();

        // cardToPlay contains 3 of rank1 and 2 of rank2
        // or contains 2 of rank1 and 3 of rank2
        if (cardsToPlay.size() == 5 &&
            ((cardsToPlay.get(0).getRank().ordinal() == rank1 && cardsToPlay.get(1).getRank().ordinal() == rank1 && cardsToPlay.get(2).getRank().ordinal() == rank1 &&
        cardsToPlay.get(3).getRank().ordinal() == rank2 && cardsToPlay.get(4).getRank().ordinal() == rank2) ||
            (cardsToPlay.get(0).getRank().ordinal() == rank2 && cardsToPlay.get(1).getRank().ordinal() == rank2 && cardsToPlay.get(2).getRank().ordinal() == rank1 &&
        cardsToPlay.get(3).getRank().ordinal() == rank1 && cardsToPlay.get(4).getRank().ordinal() == rank1))
        ) {
            return "FullHouse";
        }

        return "";
    }


    @Override
    protected int getKeyCardIndex() {
        return 2;
    }

}
