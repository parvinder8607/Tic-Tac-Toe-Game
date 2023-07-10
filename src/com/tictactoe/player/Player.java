package com.tictactoe.player;

import java.util.Scanner;

public class Player {
    private char symbol;
    private Scanner scanner;

    public Player(char symbol) {
        this.symbol = symbol;
        scanner = new Scanner(System.in);
    }

    public int getMove() {
        System.out.println("Player " + symbol + ", enter your move (1-9): ");
        return scanner.nextInt() - 1;
    }

    public char getSymbol() {
        return symbol;
    }
}
