package com.waterball.ch2.template_method.uno;

import java.util.Arrays;
import java.util.List;

public class Main {

    public static void main(String[] args) {
        Deck deck = new Deck();
        List<Player> players = Arrays.asList(new HumanPlayer(), new AIPlayer(), new AIPlayer(), new AIPlayer());

        Uno uno = new Uno(deck, players);
        uno.start();
    }
}
