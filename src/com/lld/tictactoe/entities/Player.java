package com.lld.tictactoe.entities;

import com.lld.tictactoe.components.strategies.PlayerStrategy;
import com.lld.tictactoe.enums.Symbol;

public class Player {
    private Symbol symbol;
    private PlayerStrategy playerStrategy;

    public Player(Symbol symbol, PlayerStrategy playerStrategy) {
        this.symbol = symbol;
        this.playerStrategy = playerStrategy;
    }

    public PlayerStrategy getPlayerStrategy() {
        return playerStrategy;
    }

    public Symbol getSymbol() {
        return symbol;
    }
}
