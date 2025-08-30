package com.dsa.src.golman_sachs.important;

public class TrappingRainwater {

    static int optimal(int[] arr){
        int lMax=0, rMax = 0, water=0;
        int left = 0, right = arr.length-1;
        while(left<right){
            if(arr[left]<=arr[right]){
                if(lMax>arr[left]) water+= lMax-arr[left];
                lMax = Math.max(lMax, arr[left++]);
            }else{
                if(rMax>arr[right]) water+= rMax-arr[right];
                rMax = Math.max(rMax, arr[right--]);
            }
        }
        return water;
    }

    static int betterApproach(int[] arr){
        int n = arr.length;
        int[] prefixMax = prefixMax(arr), suffixMax = suffixMax(arr);
        int water=0, height;
        for(int i=0; i<n; i++){
            height = Math.min(prefixMax[i], suffixMax[i]);
            if(height>arr[i]) water+= height-arr[i];
        }
        return water;
    }

    static int[] prefixMax(int[] arr){
        int n = arr.length;
        int[] prefixMax = new int[n];
        prefixMax[0] = arr[0];
        for(int i=1; i<n; i++){
            prefixMax[i] = Math.max(prefixMax[i-1],arr[i]);
        }
        return prefixMax;
    }

    static int[] suffixMax(int[] arr){
        int n = arr.length;
        int[] suffixMax = new int[n];
        suffixMax[n-1] = arr[n-1];
        for(int j=n-2; j>=0; j--){
            suffixMax[j] = Math.max(suffixMax[j+1],arr[j]);
        }
        return suffixMax;
    }

    public static void main(String[] args) {
        int[] arr1 = {0,1,0,2,1,0,1,3,2,1,2,1};
        int[] arr2 = {4,2,0,3,2,5};
        int[] arr3 = {1,2,3,4,5};

        System.out.println("Water trapped (arr1): " + betterApproach(arr1)); // Expected: 6
        System.out.println("Water trapped (arr2): " + betterApproach(arr2)); // Expected: 9
        System.out.println("Water trapped (arr3): " + betterApproach(arr3)); // Expected: 0

        System.out.println("Optimal Approach: ");
        System.out.println("Water trapped (arr1): " + optimal(arr1)); // Expected: 6
        System.out.println("Water trapped (arr2): " + optimal(arr2)); // Expected: 9
        System.out.println("Water trapped (arr3): " + optimal(arr3)); // Expected: 0
    }

}
