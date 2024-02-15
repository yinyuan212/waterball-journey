package com.waterball.ch2.template_method.showdown;

import java.util.Scanner;

public class HumanPlayer extends Player {

    @Override
    public void nameHimSelf(int i) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("What is your name?");
        String name = scanner.nextLine();
        setName(name);
        System.out.println(String.format("P%d is %s", i, getName()));
    }

    @Override
    public Card showCard() {
        for (int i = 0; i < getHand().getCards().size(); i++) {
            System.out.println(String.format("%d: %s", i, getHand().getCards().get(i)));
        }

        System.out.println("show your card:");
        Scanner scanner = new Scanner(System.in);
        int i = scanner.nextInt();
        return getHand().show(i);
    }
}
