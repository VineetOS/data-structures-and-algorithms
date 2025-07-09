package com.dsa.src.a2zsheet.arrays.lec3;

public class FindRepeatingAndMissingInteger {

    private static int[] findRepeatingAndMissing(int[] arr, int n) {
        int xor = 0;
        for (int i = 0; i < n; i++) {
            xor ^= arr[i];
        }
        for (int i = 1; i <= n; i++) {
            xor ^= i;
        }

        int setBit = xor & -xor; // Get the rightmost set bit
        int x = 0, y = 0;

        for (int num : arr) {
            if ((num & setBit) != 0) {
                x ^= num; // Group with set bit
            } else {
                y ^= num; // Group without set bit
            }
        }

        for (int i = 1; i <= n; i++) {
            if ((i & setBit) != 0) {
                x ^= i; // Group with set bit
            } else {
                y ^= i; // Group without set bit
            }
        }

        // Check which one is repeating and which one is missing
        boolean isXPresent = false;
        for (int num : arr) {
            if (num == x) {
                isXPresent = true;
                break;
            }
        }

        return isXPresent ? new int[]{x, y} : new int[]{y, x};
    }

    public static void main(String[] args) {
        int[] arr = { 1, 2, 3, 4, 5, 6, 7, 8, 9, 10 };
        int n = arr.length;
        int[] result = findRepeatingAndMissing(arr, n);
        System.out.println("Repeating: " + result[0] + ", Missing: " + result[1]);
    }
}
