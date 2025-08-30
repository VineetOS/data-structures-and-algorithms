package com.lld.tictactoe.components.states.impl;

import com.lld.tictactoe.components.states.GameContext;
import com.lld.tictactoe.components.states.GameState;

public class OWonState implements GameState {
    @Override
    public void next(GameContext context) {
        // No next state, game is over
    }

    @Override
    public boolean isGameOver() {
        return true;
    }
}
