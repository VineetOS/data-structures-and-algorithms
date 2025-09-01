package com.lld.atm.states.impl;

import com.lld.atm.states.AtmState;
import com.lld.atm.states.AtmStateContext;

public class CardEjectionState implements AtmState {
    @Override
    public String getStateName() {
        return "";
    }

    @Override
    public AtmState nextState(AtmStateContext context) {
        return null;
    }
}
