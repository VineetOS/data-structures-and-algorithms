package com.dsa.src.dsa_sheet.greedy;

public class MinPlatformsRequiredForRailway {

    /*
        Problem Statement:
        * Given arrival and departure times of trains, find the minimum number of platforms required
        * so that no train waits for another to leave.
        * Each train occupies a platform from its arrival time to its departure time.
    */

    public static int findMinPlatforms(int[] arrival, int[] departure) {
        int n = arrival.length;
        java.util.Arrays.sort(arrival);
        java.util.Arrays.sort(departure);

        int platformsNeeded = 0;
        int maxPlatforms = 0;
        int i = 0, j = 0;

        while (i < n && j < n) {
            if (arrival[i] <= departure[j]) {
                platformsNeeded++;
                i++;
            } else {
                platformsNeeded--;
                j++;
            }
            maxPlatforms = Math.max(maxPlatforms, platformsNeeded);
        }

        return maxPlatforms;
    }


    private static int bruteForceMinPlatforms(int[] arrival, int[] departure) {
        int n = arrival.length;
        int maxPlatforms = 0;

        for (int i = 0; i < n; i++) {
            int platformsNeeded = 1; // Start with one platform for the current train
            for (int j = 0; j < n; j++) {
                if (i != j && !(departure[i] < arrival[j] || arrival[i] > departure[j])) {
                    platformsNeeded++;
                }
            }
            maxPlatforms = Math.max(maxPlatforms, platformsNeeded);
        }

        return maxPlatforms;
    }

    public static void main(String[] args) {
        int[] arrival = {900,945,955,1100,1500,1800};
        int[] departure = {920,1200,1130,1150,1900,2000};

        //Brute Force Approach
        int minPlatformsBruteForce = bruteForceMinPlatforms(arrival, departure);
        System.out.println("Minimum number of platforms required (Brute Force): " + minPlatformsBruteForce);

        // Optimal Approach
        int minPlatforms = findMinPlatforms(arrival, departure);
        System.out.println("Minimum number of platforms required: " + minPlatforms);
    }

}
