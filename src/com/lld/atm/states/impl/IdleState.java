package com.lld.atm.states.impl;

import com.lld.atm.constants.AtmStateType;
import com.lld.atm.states.AtmState;
import com.lld.atm.states.AtmStateContext;

public class IdleState implements AtmState {
    @Override
    public String getStateName() {
        return AtmStateType.IDLE.getValue();
    }

    @Override
    public AtmState nextState(AtmStateContext context) {
        if(context.getCurrentCard() != null) {
            return context.getStateFactory().createState(AtmStateType.CARD_INSERTED);
        }
        return this;
    }
}
