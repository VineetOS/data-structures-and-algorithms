package com.lld.splitwise.components.balance_sheet;

import com.lld.splitwise.components.observer.ExpenseObserver;
import com.lld.splitwise.entities.Expense;
import com.lld.splitwise.entities.User;
import com.lld.splitwise.entities.UserPair;

import java.util.HashMap;
import java.util.Map;

public class BalanceSheet implements ExpenseObserver {
    private Map<UserPair, Double> balances = new HashMap<>();

    @Override
    public void onExpenseAdded(Expense expense) {
        updateBalances(expense);
    }

    @Override
    public void onExpenseUpdated(Expense expense) {
        updateBalances(expense);
    }

    private void updateBalances(Expense expense) {
        var splits = expense.getSplits();
        for (var entry : splits.entrySet()) {
            var user = entry.getKey();
            var amount = entry.getValue();
            if (expense.getPaidBy().equals(user)) {
                continue; // Skip if the user is the one who paid
            }
            // Assuming single payer for simplicity
            var userPair = new UserPair(expense.getPaidBy(), user);
            balances.put(userPair, balances.getOrDefault(userPair, 0.0) + amount);
        }
    }

    public double getBalance(User user1, User user2) {
        double balance1 = balances.getOrDefault(new UserPair(user1,user2), 0.0);
        double balance2 = balances.getOrDefault(new UserPair(user2,user1), 0.0);
        return balance1 - balance2;
    }

    public double getTotalBalance(User user) {
        double totalBalance = 0.0;
        for (var entry : balances.entrySet()) {
            var userPair = entry.getKey();
            var amount = entry.getValue();
            if (userPair.getFromUser().equals(user)) {
                totalBalance += amount;
            } else if (userPair.getToUser().equals(user)) {
                totalBalance -= amount;
            }
        }
        return totalBalance;
    }

    public Map<UserPair, Double> getBalances() {
        return balances;
    }
}
