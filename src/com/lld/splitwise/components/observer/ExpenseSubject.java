package com.lld.splitwise.components.observer;

import com.lld.splitwise.entities.Expense;

public interface ExpenseSubject {
    void addObserver(ExpenseObserver observer);
    void removeObserver(ExpenseObserver observer);
    void notifyExpenseAdded(Expense expense);
    void notifyExpenseUpdated(Expense expense);
}
