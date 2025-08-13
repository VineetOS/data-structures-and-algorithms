package com.dsa.src.a2zsheet.binary_search.lec2;

public class KthElementOfTwoSortedArrays {

    private static int findKthElementBinarySearch(int[] arr1, int[] arr2, int k) {
        int n1 = arr1.length, n2 = arr2.length;
        if (n1 > n2) {
            return findKthElementBinarySearch(arr2, arr1, k); // Ensure arr1 is the smaller array
        }
        int left = Math.max(0, k - n2), right = Math.min(k, n1);

        while (left <= right) {
            int mid1 = left + (right - left) / 2;
            int mid2 = k - mid1; // Calculate the corresponding index in arr2

            int l1 = Integer.MIN_VALUE, l2 = Integer.MIN_VALUE; // Left elements
            int r1 = Integer.MAX_VALUE, r2 = Integer.MAX_VALUE; // Right elements

            if(mid1 < n1) r1 = arr1[mid1];
            if(mid2 < n2) r2 = arr2[mid2];

            if(mid1 - 1 >= 0)  l1 = arr1[mid1 - 1]; // Left element from arr1
            if(mid2 - 1 >= 0) l2 = arr2[mid2 - 1]; // Left element from arr2

            if(l1 <= r2 && l2 <= r1) return Math.max(l1,l2);
            else if(l1 > r2) right = mid1 - 1; // Move towards the left in arr1
            else left = mid1 + 1; // Move towards the right in arr1

        }
        throw new IllegalArgumentException("Input arrays are not sorted or valid.");
    }

    private static int findKthElementBetterApproach(int[] arr1, int[] arr2, int k) {
        int n1 = arr1.length, n2 = arr2.length, n = n1 + n2, i = 0, j = 0;
        while (i < n1 && j < n2) {
            if (arr1[i] < arr2[j]) {
                if (k == 1) return arr1[i];
                i++;
            } else {
                if (k == 1) return arr2[j];
                j++;
            }
            k--; // Decrease k as we have found one element
        }
        // If we have exhausted one of the arrays
        while (i < n1) {
            if (k == 1) return arr1[i];
            i++;
            k--; // Decrease k as we have found one element
        }
        while (j < n2) {
            if (k == 1) return arr2[j];
            j++;
            k--; // Decrease k as we have found one element
        }
        return -1; // This should not happen if k is valid
    }

    private static int findKthElementBruteForce(int[] arr1, int[] arr2, int k) {
        int n1 = arr1.length, n2 = arr2.length;
        int[] merged = new int[n1 + n2];
        int i = 0, j = 0, index = 0;

        // Merge the two arrays
        while (i < n1 && j < n2) {
            if (arr1[i] < arr2[j]) {
                merged[index++] = arr1[i++];
            } else {
                merged[index++] = arr2[j++];
            }
        }

        // If there are remaining elements in arr1
        while (i < n1) {
            merged[index++] = arr1[i++];
        }

        // If there are remaining elements in arr2
        while (j < n2) {
            merged[index++] = arr2[j++];
        }

        // Return the k-th element (1-based index)
        return merged[k - 1];
    }

    public static void main(String[] args) {
        int[] arr1 = {2, 3, 6, 7, 9};
        int[] arr2 = {1, 4, 8, 10};
        int k = 8; // Find the 5th element in the merged sorted array

        int result = findKthElementBruteForce(arr1, arr2, k);
        System.out.println("The " + k + "th element in the merged sorted array by brute force approach is: " + result);
        result = findKthElementBetterApproach(arr1, arr2, k);
        System.out.println("The " + k + "th element in the merged sorted array by better approach is: " + result);
        result = findKthElementBinarySearch(arr1, arr2, k);
        System.out.println("The " + k + "th element in the merged sorted array by binary search approach is: " + result);
    }
}