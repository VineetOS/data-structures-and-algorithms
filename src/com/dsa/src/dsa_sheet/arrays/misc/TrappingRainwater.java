package com.dsa.src.dsa_sheet.arrays.misc;

public class TrappingRainwater {

    /**
     * This method calculates the amount of water that can be trapped after raining
     * given an array of heights representing the elevation map.
     *
     * @param heights an array of integers representing the height of bars
     * @return the total amount of trapped water
     */

    /*
       Time Complexity: O(n)*2
        Space Complexity: O(n)
     */
    private static int trap(int[] heights){
        int n = heights.length, leftMax=0, water=0;
        int[] rightMax = new int[n];

        for(int i = n-1; i >= 0; i--){
            if(i == n-1){
                rightMax[i] = 0;
            } else {
                rightMax[i] = Math.max(rightMax[i+1], heights[i]);
            }
        }

        for(int i = 0; i < n; i++){
            if(heights[i] < leftMax && heights[i] < rightMax[i]){
                water += Math.min(leftMax, rightMax[i]) - heights[i];
             }
            leftMax = Math.max(leftMax, heights[i]);
        }
        return water;
    }

    /*
    Optimal Approach: Always traverse the smaller one first
    Time Complexity: O(n)
    Space Complexity: O(1)
     */
    private static int trapOptimal(int[] heights) {
        int n = heights.length, left = 0, right = n - 1, leftMax = 0, rightMax = 0, water = 0;

        while (left < right) {
            if (heights[left] <= heights[right]) {
                if (heights[left] < leftMax) {
                    water += leftMax - heights[left];
                } else {
                    leftMax = heights[left];
                }
                left++;
            } else {
                if (heights[right] < rightMax) {
                    water += rightMax - heights[right];
                } else {
                    rightMax = heights[right];
                }
                right--;
            }
        }
        return water;
    }

    public static void main(String[] args) {
        int[] arr = {0,1,0,2,1,0,1,3,2,1,2,1};
        System.out.println("Naive Approach : " + trap(arr));
        System.out.println("Optimal Approach : " + trapOptimal(arr));
    }
}
