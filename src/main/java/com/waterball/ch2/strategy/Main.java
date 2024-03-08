package com.waterball.ch2.strategy;

import java.util.Arrays;

public class Main {

    public static void main(String[] args) {
        MatchmakingSystem matchmakingSystem = new MatchmakingSystem(
                new DistanceBasedStrategy(),
//                new HabitBasedStrategy(),
                Arrays.asList(
                        new Individual(1, "male", 25, "intro", Arrays.asList("h1", "h2"), new Coord(9, 1)),
                        new Individual(2, "male", 25, "intro", Arrays.asList("h3", "h4", "h5"), new Coord(-2, 0)),
                        new Individual(3, "male", 25, "intro", Arrays.asList("h4", "h5", "h10"), new Coord(1, 0)),
                        new Individual(4, "male", 25, "intro", Arrays.asList("h7", "h8"), new Coord(4, 4)),
                        new Individual(5, "male", 25, "intro", Arrays.asList("h9", "h10"), new Coord(5, 5))
        ));

        matchmakingSystem.match(
                new Individual(6, "male", 25, "intro", Arrays.asList("h10", "h11"), new Coord(0, 0))
        );
    }
}
