package com.waterball.ch2.chain_of_responsibility;

import com.waterball.ch2.chain_of_responsibility.handler.*;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        World world = new World(
                new DefaultCollisionHandler(
                    new WaterFireCollisionHandler(
                            new WaterWaterCollisionHandler(
                                    new FireFireCollisionHandler(
                                            new HeroFireCollisionHandler(
                                                    new HeroHeroCollisionHandler(
                                                            new HeroWaterCollisionHandler(null)
                                                    )
                                            )
                                    )
                            )
                    )
                )
        );

        Scanner scanner = new Scanner(System.in);
        while(true) {
            world.printAllSprites();

            System.out.println("input 2 numbers between 0 and 29.");
            String line = scanner.nextLine();
            String[] numbers = line.split(" ");
            int x1 = Integer.parseInt(numbers[0]);
            int x2 = Integer.parseInt(numbers[1]);

            world.handle(x1, x2);
        }
    }
}
