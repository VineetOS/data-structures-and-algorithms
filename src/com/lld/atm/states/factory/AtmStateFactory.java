package com.lld.atm.states.factory;

import com.lld.atm.constants.AtmStateType;
import com.lld.atm.states.AtmState;
import com.lld.atm.states.impl.*;

public class AtmStateFactory {
    private static AtmStateFactory instance = null;

    private AtmStateFactory(){}

    public static AtmStateFactory getInstance(){
        if(instance == null){
            instance = new AtmStateFactory();
        }
        return instance;
    }

    public AtmState createState(AtmStateType state){
        return switch (state) {
            case IDLE -> new IdleState();
            case CARD_INSERTED -> new CardInsertedState();
            case AUTHENTICATED -> new AuthenticatedState();
            case OPTION_SELECTED -> new SelectOptionsState();
            case AMOUNT_ENTERED -> new AmountEnteredState();
            case TRANSACTION -> new TransactionState();
            case EJECTING_CARD -> new CardEjectionState();
            default -> throw new IllegalArgumentException("Invalid state name: " + state);
        };
    }
}
