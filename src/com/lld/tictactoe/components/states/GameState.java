package com.lld.tictactoe.components.states;

public interface GameState {
    void next(GameContext context);
    boolean isGameOver();
}
