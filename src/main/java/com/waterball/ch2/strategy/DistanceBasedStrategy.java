package com.waterball.ch2.strategy;

import java.util.List;

public class DistanceBasedStrategy implements MatchmakingStrategy {

    @Override
    public Individual findTheMostMatched(Individual ind, List<Individual> candidates) {

        double minDistance = Double.MAX_VALUE;
        int minCandidateId = Integer.MAX_VALUE;
        Individual matched = null;


        for (Individual candidate : candidates) {
            double distance = calculateDistance(ind, candidate);
            if (distance < minDistance) {
                minDistance = distance;
                minCandidateId = candidate.getId();
                matched = candidate;
            } else if (distance == minDistance) {
                if (candidate.getId() < minCandidateId) {
                    minCandidateId = candidate.getId();
                    matched = candidate;
                }
            }
        }

        return matched;
    }

    private double calculateDistance(Individual ind, Individual candidate) {
        int xDiff = ind.getCoord().getX() - candidate.getCoord().getX();
        int yDiff = ind.getCoord().getY() - candidate.getCoord().getY();

        return Math.sqrt(xDiff * xDiff + yDiff * yDiff);
    }
}
