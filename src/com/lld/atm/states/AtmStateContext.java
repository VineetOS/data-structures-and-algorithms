package com.lld.atm.states;

import com.lld.atm.entities.Card;
import com.lld.atm.states.factory.AtmStateFactory;

public class AtmStateContext {
    private AtmState currentState;
    private Card currentCard;
    private AtmStateFactory stateFactory;

    public AtmStateContext(AtmState initialState) {
        this.currentState = initialState;
        this.stateFactory = AtmStateFactory.getInstance();
    }

    public AtmState getCurrentState() {
        return currentState;
    }

    public void setCurrentState(AtmState state) {
        this.currentState = state;
    }

    public void transitionToNextState() {
        AtmState nextState = currentState.nextState(this);
        setCurrentState(nextState);
        System.out.println("Transitioned to state: " + nextState.getStateName());

    }

    public Card getCurrentCard() {
        return currentCard;
    }

    public void setCurrentCard(Card card) {
        this.currentCard = card;
    }

    public AtmStateFactory getStateFactory() {
        return stateFactory;
    }
}
