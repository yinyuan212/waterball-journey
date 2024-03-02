package com.waterball.ch2.template_method.ood.uno;

import com.waterball.ch2.template_method.ood.base.Game;

import java.util.ArrayList;
import java.util.List;

public class Uno extends Game<Player, UnoCard> {

    private UnoCard currentCard;
    private List<UnoCard> usedCards = new ArrayList<>();
    private Player currentPlayer;

    public Uno (Deck deck, List<Player> players) {
        super(deck, players);
    }


    @Override
    public void beforeGameStart() {
        UnoCard card = (UnoCard) deck.drawCard();
        usedCards.add(card);
        currentCard = card;
        currentPlayer = players.get(0);
    }

    @Override
    public boolean whenGameEnd() {
        return currentPlayer.isNoHand();
    }

    @Override
    public void playRound() {
        for (Player player : players) {
            currentPlayer = player;
            UnoCard cardFromPlayer = player.showCard(currentCard);
            if (cardFromPlayer == null) {
                System.out.println(player.getName() + " pass");
                UnoCard newCardFromDeck = (UnoCard) deck.drawCard();
                player.addHand(newCardFromDeck);
            } else {
                usedCards.add(cardFromPlayer);
                currentCard = cardFromPlayer;
            }

            if (player.isNoHand()) {
                return;
            }

            if (deck.getCardStack().isEmpty()) {
                ((com.waterball.ch2.template_method.ood.uno.Deck) deck).shuffleUsedCards(usedCards);
                usedCards = new ArrayList<>();
            }
        }
    }

    @Override
    public Player getWinner() {
        return currentPlayer;
    }

    @Override
    public int getNumberOfHand() {
        return 5;
    }
}
