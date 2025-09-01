package com.lld.splitwise.components.observer.impl;

import com.lld.splitwise.components.observer.ExpenseObserver;
import com.lld.splitwise.components.observer.ExpenseSubject;
import com.lld.splitwise.entities.Expense;

import java.util.ArrayList;
import java.util.List;

public class ExpenseObserverManager implements ExpenseSubject {
    List<ExpenseObserver> observers = new ArrayList<>();
    List<Expense> expenses = new ArrayList<>();

    @Override
    public void addObserver(ExpenseObserver observer) {
        observers.add(observer);
    }

    @Override
    public void removeObserver(ExpenseObserver observer) {
        observers.remove(observer);
    }

    @Override
    public void notifyExpenseAdded(Expense expense) {
        for (var observer : observers) {
            observer.onExpenseAdded(expense);
        }
    }

    @Override
    public void notifyExpenseUpdated(Expense expense) {
        for (var observer : observers) {
            observer.onExpenseUpdated(expense);
        }
    }

    public void addExpense(Expense expense) {
        expenses.add(expense);
    }

    public void updateExpense(Expense expense) {
        expenses.removeIf(e -> e.getExpenseId().equals(expense.getExpenseId()));
        expenses.add(expense);
    }
}
