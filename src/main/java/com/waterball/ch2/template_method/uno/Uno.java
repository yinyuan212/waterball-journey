package com.waterball.ch2.template_method.uno;

import lombok.AllArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@AllArgsConstructor
public class Uno {

    private final Deck deck;
    private final List<Player> players;
    private Card currentCard;
    private List<Card> usedCards = new ArrayList<>();

    public Uno (Deck deck, List<Player> players) {
        this.deck = deck;
        this.players = players;
    }

    public void start() {
        nameThemselves();
        deck.shuffle();
        drawHand();
        currentCard = drawFirstCard();
        playRound();
    }

    private void nameThemselves() {
        for (int i = 0; i < players.size(); i++) {
            players.get(i).nameHimSelf(i + 1);
        }
    }

    private void drawHand() {
        for (int i = 0; i < 5; i++) {
            for (Player player : players) {
                player.addHand(deck.drawCard());
            }
        }
    }

    private Card drawFirstCard() {
        Card card = deck.drawCard();
        usedCards.add(card);
        return card;
    }

    private void playRound() {
        while (true) {
            for (Player player : players) {
                Card cardFromPlayer = player.showCard(currentCard);
                if (cardFromPlayer == null) {
                    System.out.println(player.getName() + " pass");
                    Card newCardFromDeck = deck.drawCard();
                    player.addHand(newCardFromDeck);
                } else {
                    usedCards.add(cardFromPlayer);
                    currentCard = cardFromPlayer;
                }

                if (player.getHand().getCards().size() == 0) {
                    System.out.println(player.getName() + " wins!");
                    return;
                }

                if (deck.getCardStack().isEmpty()) {
                    deck.shuffleUsedCards(usedCards);
                    usedCards = new ArrayList<>();
                }
            }
        }
    }

}
