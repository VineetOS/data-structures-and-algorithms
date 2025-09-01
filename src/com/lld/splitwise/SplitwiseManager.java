package com.lld.splitwise;

import com.lld.splitwise.components.balance_sheet.BalanceSheet;
import com.lld.splitwise.components.strategies.SettlementStrategy;
import com.lld.splitwise.entities.Transaction;

import java.util.List;

public class SplitwiseManager {

    private SettlementStrategy settlementStrategy;
    private BalanceSheet balanceSheet;

    public SplitwiseManager(SettlementStrategy settlementStrategy, BalanceSheet balanceSheet) {
        this.settlementStrategy = settlementStrategy;
        this.balanceSheet = balanceSheet;
    }

    public List<Transaction> getSettlements() {
        return settlementStrategy.getSettlements(balanceSheet.getBalances());
    }
}
