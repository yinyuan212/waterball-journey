package com.waterball.ch2.big_2;

import java.io.UnsupportedEncodingException;
import java.util.Scanner;

public class HumanPlayer extends Player {


    public HumanPlayer(CardPattern cardPattern) {
        super(cardPattern);
    }

    @Override
    public void nameYourself() {
        Scanner scanner = new Scanner(System.in);
        String name = scanner.nextLine();

        setName(name);

    }
}
