package com.waterball.ch1.showdown;

import java.util.ArrayList;
import java.util.List;

public class Showdown {


    private static final int NUMBER_Of_ROUNDS = 13;
    private final Deck deck;
    private final List<Player> players;

    public Showdown(Deck deck, List<Player> players) {
        this.deck = deck;
        this.players = players;
    }

    public void start() {
        nameThemselves();
        deck.shuffle();
        drawHand();
        playRound();
        getWinner();
    }

    private void nameThemselves() {
        for (int i = 0; i < players.size(); i++) {
            players.get(i).nameHimSelf(i + 1);
        }
    }

    private void drawHand() {
        for (int i = 0; i < NUMBER_Of_ROUNDS; i++) {
            for (Player player : players) {
                player.addHand(deck.drawCard());
            }
        }
    }

    private void playRound() {
        for (int i = 0; i < 13; i++) {
            List<Card> cards = new ArrayList<>();
            for (Player player : players) {
                cards.add(player.showCard());
            }

            int index = compare(cards);
            Player player = players.get(index);
            System.out.println(String.format("%s wins turn %d", player.getName(), i + 1));
            players.get(index).gainPoint();
        }


    }

    private static int compare(List<Card> cards) {
        int playerIndex = 0;
        Card currentCard = cards.get(0);

        for (int i = 1; i < 4; i++) {
            if (cards.get(i).isBiggerThan(currentCard)) {
                playerIndex = i;
            }
        }

        return playerIndex;
    }

    private Player getWinner() {
        int maxPoint = 0;
        Player winner = null;
        for (Player player : players) {
            if (player.getPoint() > maxPoint) {
                maxPoint = player.getPoint();
                winner = player;
            }
        }

        System.out.println(String.format("Winner goes to %s", winner.getName()));
        return winner;
    }

}
