package com.dsa.src.a2zsheet.binary_search.lec2;

public class MinDaysToMakeMBouquets {

    private static int mindDays(int[] bloomDays, int m, int k) {
        if (bloomDays == null || bloomDays.length < m * k) return -1; // Not enough flowers to make m bouquets

        int[] minMax = minAndMax(bloomDays);
        int left = minMax[0], right = minMax[1];

        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (isPossible(bloomDays, m, k, mid) == 1) {
                right = mid - 1; // Try for fewer days
            } else {
                left = mid + 1; // Increase the days
            }
        }
        return left; // The minimum days required to make m bouquets
    }

    private static int isPossible(int[] bloomDays, int m, int k, int days){
        int bouquets = 0;
        int flowers = 0;
        for (int bloomDay : bloomDays) {
            if (bloomDay <= days) {
                flowers++;
            } else {
                bouquets += flowers / k; // Count how many bouquets can be made with the current flowers
                flowers = 0; // Reset if the bloom day exceeds the current day limit
            }
        }
        bouquets += flowers / k; // Count any remaining flowers after the loop
        return bouquets >= m ? 1 : 0; // Return 1 if we can make at least m bouquets, otherwise return 0
    }

    private static int[] minAndMax(int[] bloomDay) {
        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;
        for (int day : bloomDay) {
            if (day < min) min = day;
            if (day > max) max = day;
        }
        return new int[]{min, max};
    }

    public static void main(String[] args) {
        int[] bloomDay = {7, 7, 7, 7, 13, 11, 12, 7};
        int k = 3;
        int m = 2;
        int result = mindDays(bloomDay, m, k);
        System.out.println("Minimum days to make " + m + " bouquets: " + result);
    }
}
