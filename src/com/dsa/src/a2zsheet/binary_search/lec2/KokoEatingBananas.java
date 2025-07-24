package com.dsa.src.a2zsheet.binary_search.lec2;

public class KokoEatingBananas {

    private static int minEatingSpeed(int[] piles, int h) {
        int left = 1, right = calculateMaxPile(piles);
        while (left<=right){
            int mid = left + (right-left)/2; // Calculate the mid speed
            int hoursSpent = calculateHours(piles, mid); // Calculate hours needed at this speed
            if(hoursSpent<= h)right = mid - 1; // Move to the left half to find a potentially smaller speed
            else left = mid+1;
        }
        return left; // The minimum speed that allows Koko to eat all bananas in h hours
    }

    private static int minEatingSpeedBruteForce(int[] piles, int h) {
        int maxPile = calculateMaxPile(piles);
        for (int i = 1; i <= maxPile; i++) {
            int hoursSpent = calculateHours(piles,i);
            if (hoursSpent <= h) {
                return i; // Found the minimum speed that allows Koko to eat all bananas in h hours
            }
        }
        return maxPile;
    }

    private static int calculateHours(int[] piles, int speed) {
        int hours = 0;
        for (int pile : piles) {
            hours += (int) Math.ceil((double) pile / speed); // Calculate hours needed for each pile
        }
        return hours;
    }

    private static int calculateMaxPile(int[] piles) {
        int max = 0;
        for (int pile : piles) {
            max = Math.max(max, pile);
        }
        return max;
    }

    public static void main(String[] args) {
        int[] piles = {3, 6, 7, 11};
        int h = 8;
        int minSpeed = minEatingSpeedBruteForce(piles, h);
        System.out.println("Minimum eating speed: " + minSpeed);
        minSpeed = minEatingSpeed(piles, h);
        System.out.println("Minimum eating speed using binary search: " + minSpeed);
    }
}
