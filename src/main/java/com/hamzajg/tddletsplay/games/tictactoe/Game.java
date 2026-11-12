package com.hamzajg.tddletsplay.games.tictactoe;

import java.util.Arrays;

public class Game {
    public char winner;
    public boolean isFinished;
    public char currentPlayer = 'X';

    private final String[][] board = {{"", "", ""},  {"", "", ""}, {"", "", ""}};
    private int moves;

    public void makeMove(final int row, final int col) {
        if (row < 0 || row >= board.length || col < 0 || col >= board[row].length)
            throw new IllegalArgumentException("move (" + row + ", " + col + ") is outside the board");

        if(!isFinished && board[row][col].isEmpty()) {
            board[row][col] = String.valueOf(currentPlayer);
            moves++;
            currentPlayer = currentPlayer == 'X' ? 'O' : 'X';
            checkForWinner();
        }
    }

    private void checkForWinner() {
        final int[][] winningPositions = {
                {0, 0, 0, 1, 0, 2},
                {1, 0, 1, 1, 1, 2},
                {2, 0, 2, 1, 2, 2},
                {0, 0, 1, 0, 2, 0},
                {0, 1, 1, 1, 2, 1},
                {0, 2, 1, 2, 2, 2},
                {0, 0, 1, 1, 2, 2},
                {0, 2, 1, 1, 2, 0}
        };
        Arrays.stream(winningPositions).forEach(positions -> {
            if(isPlayedMovesMatchWinningPosition(positions)) {
                winner = board[positions[0]][positions[1]].charAt(0);
                isFinished = true;
            }
        });

        // A full board with no winning line is a draw: nobody won, but the game is over.
        if(!isFinished && moves == 9)
            isFinished = true;
    }

    private boolean isPlayedMovesMatchWinningPosition(int[] positions) {
        return !board[positions[0]][positions[1]].isEmpty() &&
                board[positions[0]][positions[1]].equals(board[positions[2]][positions[3]]) &&
                board[positions[2]][positions[3]].equals(board[positions[4]][positions[5]]);
    }
}
