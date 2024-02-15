package com.waterball.ch2.template_method.showdown;

import java.util.Arrays;
import java.util.List;

public class Main {

    public static void main(String[] args) {
        Deck deck = Deck.init52Cards();
        List<Player> players = Arrays.asList(
                new HumanPlayer(),
                new AIPLayer(),
                new AIPLayer(),
                new AIPLayer()
        );

        Showdown showdown = new Showdown(deck, players);
        showdown.start();
    }

}
