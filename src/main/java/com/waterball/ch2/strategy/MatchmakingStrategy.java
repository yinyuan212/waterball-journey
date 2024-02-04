package com.waterball.ch2.strategy;

import java.util.List;

public interface MatchmakingStrategy {

    Individual findTheMostMatched(Individual ind, List<Individual> people);
}
