package com.dsa.src.miscellanous.stacks_and_queues;

public class TrappingRainwater {

    static int trap(int[] heights){
        int n = heights.length, water=0;
        if(n==0) return 0;

        int[] leftMax = new int[n];
        int[] rightMax = new int[n];
        for(int i=0, j=n-1; i<n && j>=0; i++, j--){
            if(i==0) leftMax[i] = heights[i];
            else leftMax[i] = Math.max(leftMax[i-1], heights[i]);
            if(j==n-1) rightMax[j] = heights[j];
            else rightMax[j] = Math.max(rightMax[j+1], heights[j]);
        }
        for(int i=0; i<n; i++){
            if(heights[i] < leftMax[i] && heights[i] < rightMax[i])
                water+= Math.min(leftMax[i], rightMax[i]) - heights[i];
        }
        return water;
    }

    static int trapOptimal(int[] heights) {
        int n = heights.length, water = 0;
        if (n == 0) return 0;

        int left = 0, right = n - 1;
        int leftMax = heights[left], rightMax = heights[right];
        while(left<right){
            if(heights[left] <= heights[right]){
                if(leftMax>heights[left]) water+= leftMax - heights[left];
                else leftMax = heights[left];
                left++;
            }else{
                if(rightMax>heights[right]) water+= rightMax- heights[right];
                else rightMax = heights[right];
                right--;
            }
        }
        return water;
    }

    public static void main(String[] args) {
        int[] heights = {0,1,0,2,1,0,1,3,2,1,2,1};
        int water = trap(heights);
        System.out.println("Trapped water: " + water);
        int waterOptimal = trapOptimal(heights);
        System.out.println("Trapped water (Optimal): " + waterOptimal);
    }
}
