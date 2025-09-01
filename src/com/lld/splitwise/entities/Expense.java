package com.lld.splitwise.entities;

import java.util.List;
import java.util.Map;

public class Expense {
    private Long expenseId;
    private String description;
    private Double amount;
    private User paidBy;
    private List<User> splitBetween;
    private Map<User, Double> splits; // User to amount mapping

    public Expense(Long expenseId, String description, Double amount, User paidBy, List<User> splitBetween, Map<User, Double> splits) {
        this.expenseId = expenseId;
        this.description = description;
        this.amount = amount;
        this.paidBy = paidBy;
        this.splitBetween = splitBetween;
        this.splits = splits;
    }

    public Long getExpenseId() {
        return expenseId;
    }

    public void setExpenseId(Long expenseId) {
        this.expenseId = expenseId;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Double getAmount() {
        return amount;
    }

    public void setAmount(Double amount) {
        this.amount = amount;
    }

    public User getPaidBy() {
        return paidBy;
    }

    public void setPaidBy(User paidBy) {
        this.paidBy = paidBy;
    }

    public List<User> getSplitBetween() {
        return splitBetween;
    }

    public void setSplitBetween(List<User> splitBetween) {
        this.splitBetween = splitBetween;
    }

    public Map<User, Double> getSplits() {
        return splits;
    }

    public void setSplits(Map<User, Double> splits) {
        this.splits = splits;
    }
}
