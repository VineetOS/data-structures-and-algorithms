package com.lld.splitwise.components.split.impl;

import com.lld.splitwise.components.split.Split;
import com.lld.splitwise.entities.User;

import java.util.List;
import java.util.Map;

public class ExactSplit implements Split {
    @Override
    public Map<User, Double> calculateSplit(Double amount, List<User> paidBy, Map<String, Object> splitDetails) {
        return Map.of();
    }
}
