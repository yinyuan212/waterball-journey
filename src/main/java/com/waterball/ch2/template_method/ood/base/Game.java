package com.waterball.ch2.template_method.ood.base;

import java.util.List;

// 問題2-2 一定要在template層使用泛型嗎
public abstract class Game<Player extends com.waterball.ch2.template_method.ood.base.Player, Card extends com.waterball.ch2.template_method.ood.base.Card> {

    protected final Deck deck;

    protected final List<Player> players;

    protected int round = 0;

    public Game(Deck deck, List<Player> players) {
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

    public void nameThemself() {
        for (int i = 0; i < players.size(); i++) {
            players.get(i).nameHimself(i);
        }
    }

    public void shuffle() {
        deck.shuffle();
    };
    
    public abstract void drawHand();
    public abstract void beforeGameStart();
    public abstract boolean whenGameEnd();
    public abstract void playRound();
    public abstract Player getWinner();
    public void gameOver(Player winner) {
        System.out.println(winner.getName() + " is the winner");
    };
}
