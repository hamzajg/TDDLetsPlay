package com.hamzajg.tddletsplay.games.tictactoe;

import java.util.Arrays;

public class Game {
    public char winner;
    public boolean isFinished;
    public char currentPlayer = 'X';

    private final String[][] board = {{"", "", ""},  {"", "", ""}, {"", "", ""}};

    public void makeMove(final int row, final int col) {
        if(!isFinished && board[row][col].isEmpty()) {
            board[row][col] = String.valueOf(currentPlayer);
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
    }

    private boolean isPlayedMovesMatchWinningPosition(int[] positions) {
        return !board[positions[0]][positions[1]].isEmpty() &&
                board[positions[0]][positions[1]].equals(board[positions[2]][positions[3]]) &&
                board[positions[2]][positions[3]].equals(board[positions[4]][positions[5]]);
    }
}
