package com.hamzajg.tddletsplay.games.bowling;

import org.junit.Before;
import org.junit.Test;
import org.junit.jupiter.api.Assertions;

public class BowlingGameTest {

    private Game game;

    @Before
    public void setup() {
        game = new Game();
    }

    @Test
    public void canRoll() {
        game.roll(0);
    }

    @Test
    public void gutterGame() {
        rollMany(20, 0);
        Assertions.assertEquals(0, game.score());
    }

    @Test
    public void allOnes() {
        rollMany(20, 1);
        Assertions.assertEquals(20, game.score());
    }

    @Test
    public void OneSpare() {
        rollSpare();
        game.roll(3);
        rollMany(17, 0);
        Assertions.assertEquals(16, game.score());
    }

    @Test
    public void OneStrike() {
        rollStrike();
        game.roll(3);
        game.roll(4);
        rollMany(16, 0);
        Assertions.assertEquals(24, game.score());
    }

    @Test
    public void perfectGame() {
        rollMany(12, 10);
        Assertions.assertEquals(300, game.score());
    }

    private void rollStrike() {
        game.roll(10);
    }

    private void rollSpare() {
        game.roll(5);
        game.roll(5);
    }

    private void rollMany(int n, int pins) {
        for (int i = 0; i < n; i++)
            game.roll(pins);
    }
}
