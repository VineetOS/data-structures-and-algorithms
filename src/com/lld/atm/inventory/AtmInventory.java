package com.lld.atm.inventory;

import com.lld.atm.constants.CashType;

import java.util.HashMap;
import java.util.Map;

public class AtmInventory {
    Map<CashType, Integer> cashInventory = new HashMap<>();

    public AtmInventory() {
        for (CashType cashType : CashType.values()) {
            cashInventory.put(cashType, 0);
        }
    }

    public void initializeCash(int count) {
        for (CashType cashType : CashType.values()) {
            cashInventory.put(cashType, cashInventory.getOrDefault(cashType,0)+count);
        }
    }

    public int getTotalCash(){
        int totalCash = 0;
        for(var entry: cashInventory.entrySet()){
            totalCash += entry.getKey().value * entry.getValue();
        }
        return totalCash;
    }

    public boolean hasSufficientCash(int amount){
        return getTotalCash() >= amount;
    }

    public Map<CashType, Integer> dispenseCash(int amount){
        Map<CashType, Integer> dispensedCash = new HashMap<>();
        if(!hasSufficientCash(amount)){
            return null; // insufficient cash
        }
        for(CashType cashType: CashType.values()){
            int count = amount / cashType.value;
            if(count > 0){
                int availableCount = cashInventory.getOrDefault(cashType, 0);
                int dispensedCount = Math.min(count, availableCount);
                if(dispensedCount > 0){
                    dispensedCash.put(cashType, dispensedCount);
                    amount -= dispensedCount * cashType.value;
                    cashInventory.put(cashType, availableCount - dispensedCount);
                }
            }
        }
        if(amount > 0){
            // rollback
            for(var entry: dispensedCash.entrySet()){
                CashType cashType = entry.getKey();
                int count = entry.getValue();
                cashInventory.put(cashType, cashInventory.getOrDefault(cashType, 0) + count);
            }
            return null; // cannot dispense exact amount
        }
        return dispensedCash;
    }

    public void addCash(Map<CashType, Integer> cashToAdd){
        for(var entry: cashToAdd.entrySet()){
            CashType cashType = entry.getKey();
            int count = entry.getValue();
            cashInventory.put(cashType, cashInventory.getOrDefault(cashType, 0) + count);
        }
    }
}
