package com.lld.splitwise.components.strategies;

import com.lld.splitwise.entities.Transaction;
import com.lld.splitwise.entities.UserPair;

import java.util.List;
import java.util.Map;

public interface SettlementStrategy {
    List<Transaction> getSettlements(Map<UserPair,Double> balances);
}
