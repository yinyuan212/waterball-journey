package com.waterball.ch2.big_2;

import com.waterball.ch2.big_2.CardPattern.CardPattern;

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



    public CardPatternResult play(int round, List<Card> topPlay, String topPatternName) {
        System.out.println(String.format("It's %s's turn.", name));

        List<Card> cards = handCards.getCards();
        printHandCards(cards);

        String line = scanner.nextLine();
        List<Integer> cardIndex = Arrays.stream(line.split(" ")).mapToInt(Integer::parseInt).boxed().collect(Collectors.toList());

        List<Card> cardsToPlay = cardIndex.stream()
                .filter(index -> index != -1)
                .map(cards::get)
                .collect(Collectors.toList());

        CardPatternResult cardPatternResult = cardPattern.handle(round, cardsToPlay, topPlay, topPatternName);
        String result = cardPatternResult.getResult();

        if (result.equals("cardsToPlay_WIN")) {
            StringBuilder cardsToPlayIndex = new StringBuilder();
            cardsToPlayIndex.append(String.format("%s plays %s ", name, cardPatternResult.getTopPlayName()));
            for (Card card : cardPatternResult.getTopPlay()) {
                cardsToPlayIndex.append(String.format("%s ", card));
            }

            System.out.println(cardsToPlayIndex);
            handCards.removeCards(cardIndex);
        }


        if (result.equals("PASS")) {
            System.out.println(String.format( "Player %s pass.", name));
        }

        if (result.equals("CANNOT_PASS")) {
            System.out.println(String.format("Player %s cannot pass in new round.", name));
        }

        if (result.equals("REPLAY")) {
            System.out.println("It's invalid. Please try again.");
            return play(round, topPlay, topPatternName);
        }


        return cardPatternResult;
    }

    private void printHandCards(List<Card> cards) {
        StringBuilder handCardsIndex = new StringBuilder();
        StringBuilder handCardsValue = new StringBuilder();


        for (int i = 0; i < cards.size(); i++) {
            Card card = cards.get(i);
            handCardsIndex.append(String.format("%-" + card.toString().length() + "s ", i));
            handCardsValue.append(String.format("%s ", cards.get(i)));
        }

        System.out.println(handCardsIndex);
        System.out.println(handCardsValue);
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
