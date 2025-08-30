package com.lld.tictactoe;

import com.lld.tictactoe.components.states.GameContext;
import com.lld.tictactoe.components.states.impl.OWonState;
import com.lld.tictactoe.components.states.impl.XTurnState;
import com.lld.tictactoe.components.states.impl.XWonState;
import com.lld.tictactoe.components.strategies.PlayerStrategy;
import com.lld.tictactoe.entities.Board;
import com.lld.tictactoe.entities.Player;
import com.lld.tictactoe.enums.Symbol;

public class TicTacToeGame implements BoardGame {
    private Board board;
    private Player playerX;
    private Player playerO;
    private Player currentPlayer;
    private GameContext gameContext;

    public TicTacToeGame(PlayerStrategy xStrategy, PlayerStrategy oStrategy, int size) {
        this.playerO = new Player(Symbol.O, oStrategy);
        this.playerX = new Player(Symbol.X, xStrategy);
        this.currentPlayer = playerX; // X always starts first
        this.board = new Board(size);
        this.gameContext = new GameContext(new XTurnState());
    }

    @Override
    public void play() {
        do {
            System.out.println("Current Player: " + currentPlayer.getSymbol());
            board.printBoard();
            // Get move from current player's strategy
            var move = currentPlayer.getPlayerStrategy().makeMove(board);
            // Place the symbol on the board
            board.placeMove(move, currentPlayer);

            // Check for win or draw
            board.checkGameState(gameContext);
            switchPlayer();
        } while (!gameContext.isGameOver());

        announceResult();

    }

    private void announceResult() {
        board.printBoard();
        if (gameContext.getCurrentState() instanceof OWonState) {
            System.out.println("Player O wins!");
        } else if (gameContext.getCurrentState() instanceof XWonState) {
            System.out.println("Player X wins!");
        } else {
            System.out.println("It's a draw!");
        }
    }

    private void switchPlayer() {
        currentPlayer = (currentPlayer == playerX) ? playerO : playerX;
    }
}

