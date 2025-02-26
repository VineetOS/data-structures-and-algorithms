package com.dsa.recursion;
public class PackagingWays {

    public static int countUniqueCombinations(int total, int k) {
        return countCombinationsHelper(total, k, 1);
    }

    private static int countCombinationsHelper(int remaining, int k, int start) {
        if (remaining == 0) {
            return 1; // Found a valid combination
        }
        if (remaining < 0) {
            return 0; // Exceeded the sum, invalid combination
        }

        int count = 0;
        for (int i = start; i <= k; i++) {
            count += countCombinationsHelper(remaining - i, k, i);
        }
        return count;
    }

    public static int countDP(int total, int k){
        int[][] dp = new int[total + 1][k + 1];

        // Base case: 1 way to form 0 sum (by taking nothing)
        for (int j = 1; j <= k; j++) {
            dp[0][j] = 1;
        }

        // Fill the DP table
        for (int i = 1; i <= total; i++) {
            for (int j = 1; j <= k; j++) {
                dp[i][j] = dp[i][j - 1]; // Ways without using j
                if (i >= j) {
                    dp[i][j] += dp[i - j][j]; // Ways including j
                }
            }
        }

        return dp[total][k];
    }


    public static void main(String[] args) {
        int total = 5;
        int k = 3;
        System.out.println("Number of unique combinations: " + countUniqueCombinations(total, k));
        System.out.println("Number of unique combinations DP: " + countDP(total, k));

    }
}
