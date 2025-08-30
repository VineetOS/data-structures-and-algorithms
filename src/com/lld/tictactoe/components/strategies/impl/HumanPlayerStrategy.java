package com.lld.tictactoe.components.strategies.impl;

import com.lld.tictactoe.components.strategies.PlayerStrategy;
import com.lld.tictactoe.entities.Board;
import com.lld.tictactoe.entities.Position;

import java.util.Scanner;

public class HumanPlayerStrategy implements PlayerStrategy {
    private Scanner scanner;

    public HumanPlayerStrategy() {
        this.scanner = new Scanner(System.in);
    }

    @Override
    public Position makeMove(Board board) {
        while (true){
            try{
                System.out.printf("Enter your move (row and column) between 0 and %d: ", board.getSize() - 1);
                int row = scanner.nextInt();
                int col = scanner.nextInt();
                Position move = new Position(row, col);
                if(board.isValidMove(move)) return move;
                System.out.println("Invalid move. Try again.");
            }catch (Exception e){
                System.out.println("Invalid input. Please enter two integers.");
                scanner.next(); // clear the invalid input
            }

        }
    }
}
