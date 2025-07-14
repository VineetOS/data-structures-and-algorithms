package com.dsa.src.a2zsheet.binary_search;

public class FloorAndCeil {

    private static int findCeil(int[] arr, int target){
        // Binary search to find the smallest element greater than or equal to target
        int low = 0, high = arr.length - 1;
        int ceil = -1;
        while(low<=high){
            int mid = low + (high-low)/2;
            if(arr[mid]>= target){
                ceil = arr[mid];
                high = mid-1;
            }else low = mid + 1;
        }
        return ceil;
    }

    private static int findFloor(int[] arr, int target){
        // Binary search to find the largest element less than or equal to target
        int low = 0, high = arr.length - 1;
        int floor = -1;
        while(low <= high){
            int mid = low + (high - low) / 2;
            if(arr[mid] <= target){
                floor = arr[mid]; // Update floor to current mid
                low = mid + 1; // Move right to find a potentially larger value
            } else {
                high = mid - 1; // Move left to find a smaller value
            }
        }
        return floor;
    }

    public static void main(String[] args) {
        int[] arr = {1, 2, 8, 10, 10, 12, 15, 19};
        int target = 17;
        System.out.println("Floor of " + target + ": " + findFloor(arr, target));
        System.out.println("Ceil of " + target + ": " + findCeil(arr, target));
    }
}
