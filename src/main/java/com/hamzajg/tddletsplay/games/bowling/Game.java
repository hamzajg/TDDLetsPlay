package com.hamzajg.tddletsplay.games.bowling;

public class Game {
    private static final int MAX_ROLLS = 21;

    private final int[] rolls = new int[MAX_ROLLS];
    private int currentRole;

    public void roll(int pins) {
        if (pins < 0 || pins > 10)
            throw new IllegalArgumentException("a roll must be between 0 and 10 pins: " + pins);
        if (currentRole == MAX_ROLLS)
            throw new IllegalStateException("a game has at most " + MAX_ROLLS + " rolls");

        rolls[currentRole++] = pins;
    }

    public int score() {
        int score = 0;
        int firstInFrame = 0;
        for(int frame = 0; frame<10; frame ++) {
            if(isStrike(firstInFrame)) {
                score += 10 + nextTwoBallsForStrike(firstInFrame);
                firstInFrame++;
            } else if(isSpare(firstInFrame)) {
                score += 10 + nextBallForSpare(firstInFrame);
                firstInFrame += 2;
            } else {
                score += twoBallsInFrame(firstInFrame);
                firstInFrame += 2;
            }
        }
        return score;
    }

    private int twoBallsInFrame(int firstInFrame) {
        return rolls[firstInFrame] + rolls[firstInFrame + 1];
    }

    private int nextBallForSpare(int firstInFrame) {
        return rolls[firstInFrame + 2];
    }

    private int nextTwoBallsForStrike(int firstInFrame) {
        return rolls[firstInFrame + 1] + nextBallForSpare(firstInFrame);
    }

    private boolean isStrike(int firstInFrame) {
        return rolls[firstInFrame] == 10;
    }

    private boolean isSpare(int firstInFrame) {
        return rolls[firstInFrame] + rolls[firstInFrame + 1] == 10;
    }
}
