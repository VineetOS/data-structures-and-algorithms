package com.lld.atm.constants;

public enum CashType {
    TWO_THOUSAND(2000),
    FIVE_HUNDRED(500),
    TWO_HUNDRED(200),
    HUNDRED(100);

    public final int value;
    CashType(int i) {
        this.value = i;
    }
}
