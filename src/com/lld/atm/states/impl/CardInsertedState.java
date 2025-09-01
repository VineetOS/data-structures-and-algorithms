package com.lld.atm.states.impl;

import com.lld.atm.constants.AtmStateType;
import com.lld.atm.states.AtmState;
import com.lld.atm.states.AtmStateContext;

public class CardInsertedState implements AtmState {
    @Override
    public String getStateName() {
        return AtmStateType.CARD_INSERTED.getValue();
    }

    @Override
    public AtmState nextState(AtmStateContext context) {
        return context.getStateFactory().createState(AtmStateType.AUTHENTICATED);
    }
}
