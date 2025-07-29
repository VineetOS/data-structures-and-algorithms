package com.dsa.src.a2zsheet.binary_search.lec2;

public class AggressiveCows {

    private static int maxMinDistance(int[] stalls, int cows) {
        int n = stalls.length;
        if(n < cows) {
            return -1; // Not enough stalls for cows
        }
        // Sort the stalls array
        java.util.Arrays.sort(stalls);
        int left = 0, right = stalls[n-1] - stalls[0];
        int maxMinDistance = 0;

        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (canPlaceCows(stalls, cows, mid)) {
                maxMinDistance = mid; // Found a valid distance, try for a larger one
                left = mid + 1;
            } else {
                right = mid - 1; // Try smaller distance
            }
        }
        return maxMinDistance;
    }

    private static int maxMinDistanceBruteForce(int[] stalls, int cows) {
        int n = stalls.length;
        if(n < cows) {
            return -1; // Not enough stalls for cows
        }
        // Sort the stalls array
        java.util.Arrays.sort(stalls);
        int maxMinDistance = stalls[n-1] - stalls[0];
        // Check all pairs of stalls
        for(int i=1; i<= maxMinDistance ; i++){
            if(canPlaceCows(stalls, cows, i)) continue;
            else return i-1;
        }
        return maxMinDistance;
    }

    private static boolean canPlaceCows(int[] stalls, int cows, int minDist) {
        int lastCowPosition = stalls[0];
        int count = 1; // Place the first cow in the first stall
        for (int stall : stalls) {
            if (stall - lastCowPosition >= minDist) {
                count++;
                lastCowPosition = stall;
                if (count == cows) {
                    return true; // All cows are placed successfully
                }
            }
        }
        return false; // Not all cows could be placed with the given minimum distance
    }

    public static void main(String[] args) {
        int[] stalls = {0, 3, 4, 7, 10, 9};
        int cows = 4;
        int result = maxMinDistanceBruteForce(stalls, cows);
        System.out.println("The largest minimum distance is: " + result);
        result = maxMinDistance(stalls, cows);
        System.out.println("The largest minimum distance using binary search is: " + result);
    }
}

