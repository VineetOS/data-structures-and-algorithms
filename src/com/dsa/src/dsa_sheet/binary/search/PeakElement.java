package com.dsa.src.dsa_sheet.binary.search;

public class PeakElement {

    public static int findPeakElement(int[] nums) {
        int left = 0, right = nums.length - 1;
        while (left < right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] > nums[mid + 1]) right = mid;
            else left = mid + 1;
        }
        return left;
    }

    public static void main(String[] args) {
        int[] nums = {1, 2, 3,13, 21, 1, 7, 9};
        System.out.println(findPeakElement(nums));
    }
}
