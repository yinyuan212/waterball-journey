package com.waterball.ch2.strategy;

import java.util.List;

public class HabitBasedStrategy implements MatchmakingStrategy {

    @Override
    public Individual findTheMostMatched(Individual ind, List<Individual> candidates) {

        int maxCount = 0;
        int minCandidateId = Integer.MAX_VALUE;
        Individual matched = null;


        for (Individual candidate : candidates) {
            int count = countTheSameHabits(ind, candidate);

            if (count > maxCount) {
                maxCount = count;
                minCandidateId = candidate.getId();
                matched = candidate;
            } else if (count == maxCount) {
                if (candidate.getId() < minCandidateId) {
                    minCandidateId = candidate.getId();
                    matched = candidate;
                }
            }
        }
        return matched;
    }

    private int countTheSameHabits(Individual ind, Individual candidate) {
        int count = 0;
        for (String habit : ind.getHabits()) {
            if (candidate.getHabits().contains(habit)) {
                count++;
            }
        }
        return count;
    }
}
