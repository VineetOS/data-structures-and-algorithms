package com.lld.splitwise.components.split;

import com.lld.splitwise.entities.User;

import java.util.List;
import java.util.Map;


public interface Split {

    Map<User,Double> calculateSplit(Double amount, List<User> paidBy, Map<String, Object> splitDetails);

}
