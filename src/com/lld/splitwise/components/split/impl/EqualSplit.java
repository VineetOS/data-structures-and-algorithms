package com.lld.splitwise.components.split.impl;

import com.lld.splitwise.components.split.Split;
import com.lld.splitwise.entities.User;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class EqualSplit implements Split {
    @Override
    public Map<User, Double> calculateSplit(Double amount, List<User> users, Map<String, Object> splitDetails) {
        double amountPerUser = amount / users.size();
        Map<User, Double> splits = new HashMap<>();
        for(var user: users){
            splits.put(user, amountPerUser);
        }
        return splits;
    }
}
