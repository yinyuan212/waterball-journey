package com.waterball.ch2.template_method.ood.showdown;

import com.waterball.ch2.template_method.ood.base.Deck;
import com.waterball.ch2.template_method.ood.base.Game;


import java.util.List;

public class Showdown extends Game<Player, ShowdownCard> { // 實作層，在原本泛型的位置，放入實際要用的class
    public Showdown(Deck deck, List<Player> players) {
        super(deck, players);
    }

    private int round = 0;

    @Override
    public void beforeGameStart() {
        System.out.println("showdown start!");
    }

    @Override
    public boolean whenGameEnd() {
        return round == 13;
    }

    @Override
    public void playRound() {

        //fixme: 用turn有破壞抽象，要改，並抽出for players
        Turn turn = new Turn(players);
        for (Player player : players) {
            turn.addCard(player.showCard());
        }

        Player player = turn.winThisTurn();
        player.gainPoint();
        round++;
    }

    @Override
    public Player getWinner() {
        int maxPoint = 0;
        Player winner = null;
        for (Player player : players) {
            if (player.getPoint() > maxPoint) {
                maxPoint = player.getPoint();
                winner = player;
            }
        }

        return winner;
    }

    @Override
    public int getNumberOfHand() {
        return 13;
    }
}
