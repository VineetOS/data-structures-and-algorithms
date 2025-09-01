package com.lld.splitwise.components.observer;

import com.lld.splitwise.entities.Expense;

public interface ExpenseObserver {
    void onExpenseAdded(Expense expense);

    void onExpenseUpdated(Expense expense);
}
