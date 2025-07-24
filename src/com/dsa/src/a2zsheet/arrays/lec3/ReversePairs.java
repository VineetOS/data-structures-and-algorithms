package com.dsa.src.a2zsheet.arrays.lec3;

public class ReversePairs {

    private static int countReversePairs(int[] arr, int low, int high){
        if(low>=high) return 0;
        int mid = low + (high - low) / 2;
        int count = countReversePairs(arr,low, mid) + countReversePairs(arr, mid+1,high);
        count += mergeAndCount(arr, low, mid, high);
        return count;
    }

    private static int mergeAndCount(int[] arr, int low, int mid, int high){
        int left = low, right = mid+1, k=0;
        int [] temp = new int[high - low + 1];
        int count = countPairs(arr, low, mid, high);
        while(left <= mid && right <= high){
            if(arr[left] <= arr[right]){
                temp[k++] = arr[left++];
            } else {
                temp[k++] = arr[right++];
            }
        }
        while (left<= mid) temp[k++] = arr[left++];
        while (right <= high) temp[k++] = arr[right++];
        for (int i = low, j = 0; i <= high; i++, j++) arr[i] = temp[j];
        return count;
    }

    private static int countPairs(int[] arr, int low, int mid, int high){
        int count = 0;
        int j = mid + 1;
        for (int i = low; i <= mid; i++) {
            while (j <= high && arr[i] > 2 * arr[j]) {
                j++;
            }
            count += (j - (mid + 1)); //IMPORTANT: Count how many elements in the right half are less than or equal to 2 * arr[i]
        }
        return count;
    }

    private static int bruteForce(int[] arr) {
        int count = 0;
        for (int i = 0; i < arr.length - 1; i++) {
            for (int j = i + 1; j < arr.length; j++) {
                if (arr[i] > 2 * arr[j]) {
                    count++;
                }
            }
        }
        return count;
    }

    public static void main(String[] args) {
        int[] arr = {1, 3, 2, 3, 1};
        System.out.println("Count of reverse pairs: " + bruteForce(arr));
        System.out.println("Count of reverse pairs using merge sort: " + countReversePairs(arr, 0, arr.length - 1));
    }
}
