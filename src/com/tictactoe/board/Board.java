package com.tictactoe.board;

public class Board {
    private char[] board;

    public Board() {
        board = new char[9];
        for (int i = 0; i < 9; i++) {
            board[i] = ' ';
        }
    }

    public void display() {
        System.out.println("-------------");

        for (int i = 0; i < 9; i += 3) {
            System.out.print("| ");
            for (int j = i; j < i + 3; j++) {
                System.out.print(board[j] + " | ");
            }
            System.out.println("\n-------------");
        }
    }

    public boolean isValidMove(int position) {
        if (position < 0 || position >= 9) {
            return false;
        }

        return board[position] == ' ';
    }

    public void makeMove(int position, char player) {
        board[position] = player;
    }

    public boolean isBoardFull() {
        for (int i = 0; i < 9; i++) {
            if (board[i] == ' ') {
                return false;
            }
        }
        return true;
    }

    public boolean checkWin(char player) {
        // Check rows
        for (int i = 0; i < 9; i += 3) {
            if (board[i] == player &&
                    board[i + 1] == player &&
                    board[i + 2] == player) {
                return true;
            }
        }

        // Check columns
        for (int i = 0; i < 3; i++) {
            if (board[i] == player &&
                    board[i + 3] == player &&
                    board[i + 6] == player) {
                return true;
            }
        }

        // Check diagonals
        if ((board[0] == player && board[4] == player && board[8] == player) ||
                (board[2] == player && board[4] == player && board[6] == player)) {
            return true;
        }

        return false;
    }
}
