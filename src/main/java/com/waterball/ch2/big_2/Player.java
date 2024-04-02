package com.waterball.ch2.big_2;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public abstract class Player {


    private HandCards handCards = new HandCards();

    private String name;

    private final CardPattern cardPattern;

    private Scanner scanner = new Scanner(System.in);

    public Player(CardPattern cardPattern) {
        this.cardPattern = cardPattern;
    }



    public List<Card> play(int round, int playerIndex, List<Card> topPlay) {
        System.out.println(String.format("It's %s's turn.", name));

        StringBuilder handCardsIndex = new StringBuilder();
        StringBuilder handCardsValue = new StringBuilder();

        List<Card> cards = handCards.getCards();
        for (int i = 0; i < cards.size(); i++) {
            Card card = cards.get(i);
            handCardsIndex.append(String.format("%-" + card.toString().length() + "s ", i));
            handCardsValue.append(String.format("%s ", cards.get(i)));
        }

        System.out.println(handCardsIndex);
        System.out.println(handCardsValue);

        String line = scanner.nextLine();
        List<Integer> cardIndex = Arrays.stream(line.split(" ")).mapToInt(Integer::parseInt).boxed().collect(Collectors.toList());

        if (cardIndex.size() != 1 || cardIndex.get(0) == -1) {
            List<Card> cardsToPlay = cardIndex.stream()
                    .map(cards::get)
                    .collect(Collectors.toList());

            // if handle return true, means cardsToPlay is valid and bigger than topPlay
            // else return false. topPlay keeps unchanged
            if (cardPattern.isCardsToPlayBiggerThanTopPay(round, playerIndex, topPlay, cardsToPlay)) {
                return cardsToPlay;
            }
        }

        return null;
    }


    public abstract void nameYourself();

    public void addCard(Card card) {
        handCards.addCard(card);
    }

    public HandCards getHandCards() {
        return handCards;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }


}
