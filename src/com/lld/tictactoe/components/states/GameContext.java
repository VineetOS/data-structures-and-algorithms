package com.lld.tictactoe.components.states;

public class GameContext {
    private GameState currentState;

    public GameContext(GameState initialState) {
        this.currentState = initialState;
    }

    public void setState(GameState state) {
        this.currentState = state;
    }

    public void next() {
        currentState.next(this);
    }

    public boolean isGameOver() {
        return currentState.isGameOver();
    }

    public GameState getCurrentState() {
        return currentState;
    }
}
