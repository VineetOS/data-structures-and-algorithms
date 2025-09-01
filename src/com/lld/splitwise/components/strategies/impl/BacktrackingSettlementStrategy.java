package com.lld.splitwise.components.strategies.impl;

import com.lld.splitwise.components.strategies.SettlementStrategy;
import com.lld.splitwise.entities.Transaction;
import com.lld.splitwise.entities.User;
import com.lld.splitwise.entities.UserPair;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class BacktrackingSettlementStrategy implements SettlementStrategy {
    @Override
    public List<Transaction> getSettlements(Map<UserPair, Double> balances) {
        List<Transaction> transactions = new ArrayList<>();
        Map<User, Double> balancesMap = new HashMap<>();
        for(var entry: balances.entrySet()){
            var userPair = entry.getKey();
            var debitor = userPair.getToUser();
            var creditor = userPair.getFromUser();
            balancesMap.put(debitor, balancesMap.getOrDefault(debitor, 0.0) - entry.getValue());
            balancesMap.put(creditor, balancesMap.getOrDefault(creditor, 0.0) + entry.getValue());
        }
        List<User> creditors = new ArrayList<>();
        for(var entry: balancesMap.entrySet()){
            creditors.add(entry.getKey());

        }
        return List.of();
    }
}
