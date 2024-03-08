package com.waterball.ch2.template_method.ood.uno;


import java.util.Scanner;

public class HumanPlayer extends Player {

    @Override
    public void nameHimself(int i) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("What is your name?");
        String name = scanner.nextLine();
        setName(name);
        System.out.println(String.format("P%d is %s", i, getName()));
    }

    @Override
    public UnoCard showCard(UnoCard card) {
        boolean cadShowCardInHand = false;
        System.out.println("current card: " + card);

        System.out.println("cards in hand: ");
        for (int i = 0; i < getHand().getCards().size(); i++) {
            UnoCard cardInHand = getHand().getCards().get(i);
            if (cardInHand.getColor() == card.getColor() || cardInHand.getNumber() == card.getNumber()) {
                cadShowCardInHand = true;
                System.out.println(String.format("%d: %s", i, cardInHand));
            }
        }

        if (cadShowCardInHand) {
            Scanner scanner = new Scanner(System.in);
            int i = scanner.nextInt();
            return getHand().showCard(i);
        } else {
            return null;
        }
    }
}
