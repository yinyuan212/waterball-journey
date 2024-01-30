package com.waterball.ch2.strategy;

import java.util.List;

public class MatchmakingSystem {

    private final MatchmakingStrategy matchmakingStrategy;

    private final List<Individual> people;

    public MatchmakingSystem(MatchmakingStrategy matchmakingStrategy, List<Individual> people) {
        this.matchmakingStrategy = matchmakingStrategy;
        this.people = people;
    }
}
