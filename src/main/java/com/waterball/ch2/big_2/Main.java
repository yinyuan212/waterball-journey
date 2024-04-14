package com.waterball.ch2.big_2;

import com.waterball.ch2.big_2.CardPattern.*;

import java.util.Arrays;
import java.util.List;

public class Main {

    public static void main(String[] args) {

        CardPattern cardPattern = new Single(new Pair(new Straight(new FullHouse(null))));

        List<Player> players = Arrays.asList(
                new HumanPlayer(cardPattern),
                new HumanPlayer(cardPattern),
                new HumanPlayer(cardPattern),
                new HumanPlayer(cardPattern)
        );

        Deck deck = new Deck();

        Big2 big2 = new Big2(players, deck);
        big2.start();
    }
}
