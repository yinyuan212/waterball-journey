package com.waterball.ch2.template_method.showdown;

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
        for (int i = 0; i < 13; i++) {
            for (Player player : players) {
                player.addHand(deck.drawCard());
            }
        }
    }

    private void playRound() {
        for (int i = 0; i < NUMBER_Of_ROUNDS; i++) {
            Turn turn = new Turn(players);
            for (Player player : players) {
                turn.addCard(player.showCard());
            }

            Player player = turn.winThisTurn();
            player.gainPoint();
        }
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
