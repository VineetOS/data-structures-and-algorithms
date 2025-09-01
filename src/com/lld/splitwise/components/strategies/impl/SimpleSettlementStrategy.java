package com.lld.splitwise.components.strategies.impl;

import com.lld.splitwise.components.strategies.SettlementStrategy;
import com.lld.splitwise.entities.Transaction;
import com.lld.splitwise.entities.User;
import com.lld.splitwise.entities.UserPair;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class SimpleSettlementStrategy implements SettlementStrategy {

    @Override
    public List<Transaction> getSettlements(Map<UserPair, Double> balances) {
        List<Transaction> transactions = new ArrayList<>();
        Map<User, Double> balancesMap = new HashMap<>();
        int debitorIndex = 0;
        int creditorIndex = 0;
        for(var entry: balances.entrySet()){
            var userPair = entry.getKey();
            var debitor = userPair.getToUser();
            var creditor = userPair.getFromUser();
            balancesMap.put(debitor, balancesMap.getOrDefault(debitor, 0.0) - entry.getValue());
            balancesMap.put(creditor, balancesMap.getOrDefault(creditor, 0.0) + entry.getValue());
        }
        List<User> debtors = new ArrayList<>();
        List<User> creditors = new ArrayList<>();
        for(var entry: balancesMap.entrySet()){
            if(entry.getValue() < 0){
                debtors.add(entry.getKey());
            } else if(entry.getValue() > 0){
                creditors.add(entry.getKey());
            }
        }

        while (debitorIndex<debtors.size() && creditorIndex<creditors.size()){
            var debitor = debtors.get(debitorIndex);
            var creditor = creditors.get(creditorIndex);
            var debitorBalance = balancesMap.get(debitor);
            var creditorBalance = balancesMap.get(creditor);
            if(debitorBalance < creditorBalance){
                transactions.add(new Transaction(debitor, creditor, debitorBalance));
                balancesMap.put(creditor, creditorBalance - debitorBalance);
                debitorIndex++;
            } else if(debitorBalance > creditorBalance){
                transactions.add(new Transaction(debitor, creditor, creditorBalance));
                balancesMap.put(debitor, -(debitorBalance - creditorBalance));
                creditorIndex++;
            } else {
                transactions.add(new Transaction(debitor, creditor, debitorBalance));
                debitorIndex++;
                creditorIndex++;
            }
        }
        return transactions;
    }
}
