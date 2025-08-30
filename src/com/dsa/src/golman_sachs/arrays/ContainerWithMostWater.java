package com.dsa.src.golman_sachs.arrays;

public class ContainerWithMostWater {

    static int container(int[] arr){
        if(arr.length<=1) return 0;
        int n = arr.length, left = 0, right = n-1, maxWater=0;
        while(left<right){
            int water = Math.min(arr[left],arr[right])*(right-left);
            maxWater = Math.max(maxWater, water);
            if(arr[left]<=arr[right]) left++;
            else right--;
        }
        return maxWater;
    }

    public static void main(String[] args) {
        int[] heights = {1, 8, 6, 2, 5, 4, 8, 3, 7};
        System.out.println(container(heights));
    }
}
