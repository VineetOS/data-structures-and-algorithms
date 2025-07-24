package com.dsa.src.a2zsheet.binary_search.lec2;

public class NthRoot {

    private static int calculatePower(int base, int exponent) {
        int result = 1;
        for (int i = 0; i < exponent; i++) {
            result *= base;
        }
        return result;
    }

    private static int findNthRoot(int n, int m) {
        int low = 1, high = m, ans = 0;
        while (low<=high){
            int mid = low + (high - low)/2;
            int midN = func(mid, n, m);
            if(midN == 1){
                return mid; // Found the exact nth root
            } else if(midN == 2){
                high = mid - 1; // mid^n is greater than m, search in the lower half
            } else {
                ans = mid; // mid^n is less than m, store as potential answer
                low = mid + 1; // search in the upper half
            }
        }
        return ans; // Return the largest integer whose nth power is less than or equal to x
    }

    public static int func(int mid, int n, int m) {
        long ans = 1;
        for (int i = 1; i <= n; i++) {
            ans = ans * mid;
            if (ans > m) return 2;
        }
        if (ans == m) return 1;
        return 0;
    }


    public static void main(String[] args) {
        int n = 4; // The root we want to find
        int x = 256; // The number for which we want to find the nth root
        int result = findNthRoot(n, x);
        System.out.println("The " + n + "th root of " + x + " is: " + result);
    }
}
