package com.waterball.ch2.big_2;

import java.util.Collections;
import java.util.List;

public class Big2 {

    private final List<Player> players;
    private final Deck deck;


    private int round = 1;
    private List<Card> topPlay = null;
    private Player topPlayer = null;
    private String topPatternName = "";

    public Big2(List<Player> players, Deck deck) {
        this.players = players;
        this.deck = deck;
    }


    public void start() {
        initialDeck();
        namePlayers();

        for (Player player : players) {
            System.out.println(player.getName());
        }

        dealCards();
        decidePlayerSequence();
        play();
    }

    private void initialDeck() {
        deck.init52Cards();
    }

    private void namePlayers() {
        for (Player player : players) {
            player.nameYourself();
        }
    }

    private void dealCards() {
         while (true) {
            for (Player player : players) {
                if (deck.isEmpty()) {
                    return;
                }
                player.addCard(deck.deal());
            }
        }
    }

    private void decidePlayerSequence() {
        int rotate = 0;
        for (int i = 0; i < 4; i++) {
            if (players.get(i).getHandCards().hasClubThree()) {
                rotate = (4 - i) % 4;
                break;
            }
        }

        Collections.rotate(players, rotate);
    }

    private void play() {
        int turn = -1;
        int passCount = 0;
        while (true) {

            boolean isNewRound = passCount == 3;
            if (isNewRound) {
                System.out.println(String.format("Round %d starts.", round));
                topPlay = null;
                topPatternName = "";
                round++;
            }

            turn++;

            Player player = players.get(turn % 4);
            CardPatternResult cardPatternResult = player.play(round, topPlay, topPatternName);
            String result = cardPatternResult.getResult();

            // 有打出對的牌
            if ("carsToPlay_WIN".equals(result)) {
                topPlay = cardPatternResult.getTopPlay();
                topPlayer = player;
                topPatternName = cardPatternResult.getTopPlayName();
                passCount = 0;

            }
            // 玩家 pass
            else if ("PASS".equals(result)) {
                passCount++;
            }

            if (player.getHandCards().isEmpty()) {
                System.out.println(String.format("Player %s wins", topPlayer.getName()));
                return;
            }
        }
    }
}
