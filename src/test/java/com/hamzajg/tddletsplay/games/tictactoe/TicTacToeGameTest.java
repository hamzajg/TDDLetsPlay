package com.hamzajg.tddletsplay.games.tictactoe;

import org.junit.Test;
import org.junit.jupiter.api.Assertions;

public class TicTacToeGameTest {
    @Test
    public void canStartGame() {
        var game = new Game();

        Assertions.assertEquals('X', game.currentPlayer);
    }

    @Test
    public void canMakeMove() {
        var game = new Game();

        game.makeMove(0, 0);

        Assertions.assertEquals('O', game.currentPlayer);
        Assertions.assertEquals(Character.MIN_VALUE, game.winner);
        Assertions.assertFalse(game.isFinished);
    }

    @Test
    public void canMakeMultiMoves() {
        var game = new Game();

        game.makeMove(0, 0);
        game.makeMove(1, 0);

        Assertions.assertEquals('X', game.currentPlayer);
        Assertions.assertEquals(Character.MIN_VALUE, game.winner);
        Assertions.assertFalse(game.isFinished);
    }

    @Test
    public void playerXWins() {
        var game = new Game();

        game.makeMove(0, 0);
        game.makeMove(1, 0);
        game.makeMove(0, 1);
        game.makeMove(1, 1);
        game.makeMove(0, 2);
        game.makeMove(2, 2);

        Assertions.assertTrue(game.isFinished);
        Assertions.assertEquals('X', game.winner);
    }

}
