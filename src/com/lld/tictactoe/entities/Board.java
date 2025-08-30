package com.lld.tictactoe.entities;

import com.lld.tictactoe.components.states.GameContext;
import com.lld.tictactoe.components.states.GameState;
import com.lld.tictactoe.components.states.impl.DrawState;
import com.lld.tictactoe.components.states.impl.OWonState;
import com.lld.tictactoe.components.states.impl.XTurnState;
import com.lld.tictactoe.components.states.impl.XWonState;
import com.lld.tictactoe.enums.Symbol;

import java.util.Arrays;

public class Board {

    int size;
    Symbol[][] grid;

    public Board(int size) {
        this.size = size;
        this.grid = new Symbol[size][size];
        for(Symbol[] row : grid) {
            Arrays.fill(row, Symbol.EMPTY);
        }
    }

    public boolean isValidMove(Position position) {
        boolean isInBounds = position.row >= 0 && position.row < size && position.col >= 0 && position.col < size;
        return isInBounds && grid[position.row][position.col] == Symbol.EMPTY;
    }

    public void placeMove(Position position, Player player) {
        grid[position.row][position.col] = player.getSymbol();
    }

    public void checkGameState(GameContext context) {
        GameState currentState = context.getCurrentState();

        //check rows

        for(int i=0; i<size; i++){
            if(grid[i][0] != Symbol.EMPTY && isWinningLine(grid[i])){
                context.setState(getWinningState(currentState));
                return;
            }
        }

        //check columns
        for(int j=0; j<size; j++){
            Symbol[] column = new Symbol[size];
            for (int i = 0; i < size; i++) {
                column[i] = grid[i][j];
            }
            if(column[0] != Symbol.EMPTY && isWinningLine(column)) {
                context.setState(getWinningState(currentState));
                return;
            }
        }

        //check main diagonal
        Symbol[] mainDiagonal = new Symbol[size];
        Symbol[] antiDiagonal = new Symbol[size];
        for(int i=0; i<size; i++) {
            mainDiagonal[i] = grid[i][i];
            antiDiagonal[i] = grid[i][size - 1 - i];
        }

        if(mainDiagonal[0] != Symbol.EMPTY && isWinningLine(mainDiagonal)) {
            context.setState(getWinningState(currentState));
            return;
        }

        if(antiDiagonal[0] != Symbol.EMPTY && isWinningLine(antiDiagonal)) {
            context.setState(getWinningState(currentState));
            return;
        }

        if(isBoardFull()) {
            context.setState(new DrawState());
        }
    }

    private boolean isWinningLine(Symbol[] line) {
        Symbol first = line[0];
        for(Symbol symbol : line) {
            if(symbol != first) return false;
        }
        return true;
    }

    private boolean isBoardFull(){
        for(int i=0; i<size; i++)
            for (int j=0; j<size; j++)
                if (grid[i][j] == Symbol.EMPTY) return false;
        return true;
    }

    private GameState getWinningState(GameState currentState){
        return currentState instanceof XTurnState? new XWonState(): new OWonState();
    }

    public void printBoard() {
        System.out.println("Current Board:");
        for(int i=0; i<size; i++) {
            for(int j=0; j<size; j++) {
                System.out.print(grid[i][j] + " ");
            }
            System.out.println();
        }
    }

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }
}
