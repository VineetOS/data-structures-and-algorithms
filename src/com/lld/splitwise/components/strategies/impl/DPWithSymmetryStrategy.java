package com.lld.splitwise.components.strategies.impl;

import com.lld.splitwise.components.strategies.SettlementStrategy;
import com.lld.splitwise.entities.Transaction;
import com.lld.splitwise.entities.UserPair;

import java.util.List;
import java.util.Map;

public class DPWithSymmetryStrategy implements SettlementStrategy {
    @Override
    public List<Transaction> getSettlements(Map<UserPair, Double> balances) {
        return List.of();
    }
}
