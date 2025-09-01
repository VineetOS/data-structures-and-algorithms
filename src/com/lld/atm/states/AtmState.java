package com.lld.atm.states;

public interface AtmState {
    String getStateName();
    AtmState nextState(AtmStateContext context);
}
