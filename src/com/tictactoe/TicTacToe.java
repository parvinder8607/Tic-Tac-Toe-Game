package com.tictactoe;
import com.tictactoe.board.Board;
import com.tictactoe.player.Player;

public class TicTacToe {
    private Board board;
    private Player player1;
    private Player player2;
    private Player currentPlayer;
    private boolean gameOver;

    public TicTacToe() {
        board = new Board();
        player1 = new Player('X');
        player2 = new Player('O');
        currentPlayer = player1;
        gameOver = false;
    }

    public void play() {
        System.out.println("Let's play Tic Tac Toe!");

        while (!gameOver) {
            board.display();
            int move = currentPlayer.getMove();

            if (board.isValidMove(move)) {
                board.makeMove(move, currentPlayer.getSymbol());

                if (board.checkWin(currentPlayer.getSymbol())) {
                    board.display();
                    System.out.println("Player " + currentPlayer.getSymbol() + " wins!");
                    gameOver = true;
                } else if (board.isBoardFull()) {
                    board.display();
                    System.out.println("It's a tie!");
                    gameOver = true;
                } else {
                    currentPlayer = (currentPlayer == player1) ? player2 : player1;
                }
            } else {
                System.out.println("Invalid move. Please try again.");
            }
        }
    }

    public static void main(String[] args) {
        TicTacToe game = new TicTacToe();
        game.play();
    }
}
