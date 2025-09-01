package com.lld.atm.constants;

public enum AtmStateType {

    IDLE("Idle"),
    CARD_INSERTED("Card Inserted"),
    AUTHENTICATED("Authenticated"),
    OPTION_SELECTED("Option Selected"),
    AMOUNT_ENTERED("Amount Entered"),
    TRANSACTION("Transaction"),
    EJECTING_CARD("Ejecting Card"),
    OUT_OF_SERVICE("Out of Service");

    public final String value;
    AtmStateType(String i) {
        this.value = i;
    }

    public String getValue() {
        return value;
    }
}
