package com.dsa.src.golman_sachs.greedy;

public class CircularGasStations {

    static int startingGasStation(int[] gas, int[] cost){
        if(gas == null || cost == null || gas.length == 0 || cost.length ==0) return -1;
        int total = 0, curr = 0, start = 0;
        for (int i = 0; i < gas.length; i++) {
            total += gas[i] - cost[i];
            curr += gas[i] - cost[i];

            if (curr < 0) {
                // can't start from 'start' to here, skip them
                start = i + 1;
                curr = 0;
            }
        }
        return total >= 0 ? start : -1;
    }

    public static void main(String[] args) {
        int[] gas = {6, 1, 4, 3, 5, 7, 2, 8, 6, 4};
        int[] cost = {7, 2, 3, 6, 2, 6, 5, 3, 7, 4};
        System.out.println("Index: "+ startingGasStation(gas,cost));
    }
}
