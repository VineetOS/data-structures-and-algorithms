package com.dsa.src.arrays.dsa_sheet.part1;

public class StockBuySell {

    private static int maximumProfit(int[] arr){
        int n = arr.length, minVal = Integer.MAX_VALUE, maxProfit = 0;

        for (int j : arr) {
            if (j < minVal) minVal = j;
            if (j - minVal > maxProfit) maxProfit = j - minVal;
        }
        return maxProfit;
    }

    public static void main(String[] args) {
        int[] arr = {7,1,5,3,6,4};
        System.out.println(maximumProfit(arr));
    }
}
