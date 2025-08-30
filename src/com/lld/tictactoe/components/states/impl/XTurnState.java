package com.lld.tictactoe.components.states.impl;

import com.lld.tictactoe.components.states.GameContext;
import com.lld.tictactoe.components.states.GameState;

public class XTurnState implements GameState {
    @Override
    public void next(GameContext context) {
        context.setState(new OTurnState());
    }

    @Override
    public boolean isGameOver() {
        return false;
    }
}
