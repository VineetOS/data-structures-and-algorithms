package com.dsa.src.a2zsheet.arrays.lec2;

public class StockBuySell {

    private static int maxProfit(int[] prices) {
        int maxProfit = 0;
        int minPrice = Integer.MAX_VALUE;
        for(int price: prices){

            minPrice = Math.min(price, minPrice);
            maxProfit = Math.max(maxProfit,price-minPrice);
        }
        return maxProfit;
 }

    public static void main(String[] args) {
        int[] prices = {7, 1, 5, 3, 6, 4};
        System.out.println(maxProfit(prices));
    }
}
