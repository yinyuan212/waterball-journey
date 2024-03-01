package com.waterball.ch2.template_method.ood.showdown;

import java.util.ArrayList;
import java.util.List;

public class Turn {

    private final List<Player> players;
    private List<ShowdownCard> cards = new ArrayList<>();

    public Turn(List<Player> players) {
        this.players = players;
    }

    public void addCard(ShowdownCard card) {
        cards.add(card);
    }

    public Player winThisTurn(){
        int playerIndex = 0;
        ShowdownCard currentCard = cards.get(0);

        for (int i = 1; i < 4; i++) {
            if (cards.get(i).isBiggerThan(currentCard)) {
                playerIndex = i;
            }
        }

        Player player = players.get(playerIndex);
        System.out.println(String.format("%s wins this turn", player.getName()));
        System.out.println("");
        return player;
    }

}
