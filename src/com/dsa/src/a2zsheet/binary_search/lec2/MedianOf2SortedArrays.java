package com.dsa.src.a2zsheet.binary_search.lec2;

public class MedianOf2SortedArrays {

    private static double binarySearch(int[] nums1, int[] nums2) {
        int n1 = nums1.length, n2 = nums2.length, n = n1 + n2;
        int left = 0, right = n1;

        while (left <= right) {
            int mid = left + (right - left) / 2;
            //we take mid-elements from nums1 and the rest from nums2
            int l1 = mid-1>=0? nums1[mid-1]: Integer.MIN_VALUE; // left element from nums1:
            int l2 = (n/2 - mid - 1)>=0 ? nums2[n/2 - mid - 1] : Integer.MIN_VALUE; // left element from nums2
            int r1 = mid < n1 ? nums1[mid] : Integer.MAX_VALUE; // right element from nums1
            int r2 = (n/2-mid<n2) ? nums2[n/2-mid] : Integer.MAX_VALUE; // right element from nums2
            if(l1>r2) right = mid-1;
            else if(l2>r1) left = mid + 1;
            else {
                // Found the correct partition
                if (n % 2 == 0) {
                    return (Math.max(l1,l2) +
                            Math.min(r1, r2)) / 2.0;
                } else {
                    return Math.min(r1,r2);
                }
            }
        }
        throw new IllegalArgumentException("Input arrays are not sorted or valid.");
    }

    private static double findMedianSortedArraysBruteForce(int[] nums1, int[] nums2) {
        int n = nums1.length + nums2.length;
        int[] merged = new int[n];
        int i = 0, j = 0, k = 0;

        // Merge the two arrays
        while (i < nums1.length && j < nums2.length) {
            if (nums1[i] < nums2[j]) {
                merged[k++] = nums1[i++];
            } else {
                merged[k++] = nums2[j++];
            }
        }

        // If there are remaining elements in nums1
        while (i < nums1.length) {
            merged[k++] = nums1[i++];
        }

        // If there are remaining elements in nums2
        while (j < nums2.length) {
            merged[k++] = nums2[j++];
        }

        // Calculate the median
        if (n % 2 == 0) {
            return (merged[n / 2 - 1] + merged[n / 2]) / 2.0;
        } else {
            return merged[n / 2];
        }
    }

    private static double medianByBetterApproach(int[] nums1, int[] nums2){
        int n1 = nums1.length, n2 = nums2.length, n = n1 + n2;
        int count=0, i=0, j=0, val1=0, val2=0;
        while(i<n1 && j<n2) {
            if (nums1[i] < nums2[j]) {
                if(count == n /2 -1) val1 = nums1[i];
                if(count == n/2) val2 = nums1[i];
                count++;
                i++;
            } else {
                if(count == n / 2-1) val1 = nums2[j];
                else if(count == n/2 ) val2 = nums2[j];
                count++;
                j++;
            }

        }
        // If one array is exhausted, continue with the other
        while (i < n1) {
            if(count == n / 2 -1) val1 = nums1[i];
            if(count == n/2) val2 = nums1[i];
            i++;
            count++;
        }

        while (j < n2){
            if(count == n/2 -1) val1 = nums2[j];
            if(count == n/2) val2 = nums2[j];
            j++;
            count++;
        }

        return (n % 2 == 0) ? (val1 + val2) / 2.0 : val1;
    }

    public static void main(String[] args) {
        int[] nums1 = {1, 3,5};
        int[] nums2 = {2};
        double median = findMedianSortedArraysBruteForce(nums1, nums2);
        System.out.println("The median by brute force approach is: " + median);
        median = medianByBetterApproach(nums1, nums2);
        System.out.println("The median by better approach is: " + median);
        median = binarySearch(nums1, nums2);
        System.out.println("The median by binary search is: " + median);
    }
}
