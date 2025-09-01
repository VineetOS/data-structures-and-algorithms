package com.lld.splitwise.components.split.impl;

import com.lld.splitwise.components.split.Split;
import com.lld.splitwise.entities.User;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class PercentageSplit implements Split {
    @Override
    public Map<User, Double> calculateSplit(Double amount, List<User> paidBy, Map<String, Object> splitDetails) {
        Map<User,Double> percentageMap = (Map<User, Double>) splitDetails.get("percentages");
        Map<User,Double> splits = percentageMap.entrySet().stream().collect(
                Collectors.toMap(
                        Map.Entry::getKey,
                        entry -> (entry.getValue() / 100) * amount
                )
        );
        return splits;
    }
}
