package com.waterball.ch2.template_method.ood.base;

import java.util.List;


public abstract class Game<Player extends com.waterball.ch2.template_method.ood.base.Player<Card>, Card> {

    protected final Deck<Card> deck;

    protected final List<Player> players;

    public Game(Deck<Card> deck, List<Player> players) {
        this.deck = deck;
        this.players = players;
    }

    public void start() {
        try {
            nameThemself();
            shuffle();
            drawHand();
            beforeGameStart();
            while (!whenGameEnd()) {
                playRound();
            }
            Player winner = getWinner();
            gameOver(winner);
        } catch (Exception e) {
            System.out.println(e.getMessage());
            e.printStackTrace();
        }
    }

    protected void nameThemself() {
        for (int i = 0; i < players.size(); i++) {
            players.get(i).nameHimself(i);
        }
    }

    private void shuffle() {
        deck.shuffle();
    };
    
    public void drawHand() {
        int numberOfHand = getNumberOfHand();
        for (int i = 0; i < numberOfHand; i++) {
            for (Player player : players) {
                Card card = deck.drawCard();
                player.addHand(card);
            }
        }
    };
    protected abstract void beforeGameStart();
    protected abstract boolean whenGameEnd();
    protected abstract void playRound();
    protected abstract Player getWinner();
    protected void gameOver(Player winner) {
        System.out.println(winner.getName() + " is the winner");
    };
    protected abstract int getNumberOfHand();
}
