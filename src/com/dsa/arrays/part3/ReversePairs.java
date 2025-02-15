package com.dsa.arrays.part3;


public class ReversePairs {


    /*
    Time Complexity: O(N^2)
    Space Complexity O(1)
     */
    private static int bruteForce(int[] arr){
        int n = arr.length, ans=0;
        for(int i=0; i<n-1;i++){
            for(int j=i+1; j<n; j++){
                if(arr[i]>2*arr[j])
                    ans++;
            }
        }
        return ans;
    }

    public static int mergeSort(int[] arr, int low, int high ){
        int count=0;
        if(low>=high)
            return 0;

        //NOTE: sometimes, sum of high and low can reach out of integer bounds,
        //To avoid this we use the following expression for calculating mid
        int mid = low + (high-low)/2;

        count+=mergeSort(arr, low, mid);
        count+=mergeSort(arr, mid+1, high);
        count+= countReversePairs(arr, low,mid,high);
        merge(arr,low,mid,high);
        return count;

    }

    public static void merge(int[] arr, int low, int mid, int high){
        int[] merged = new int[high - low + 1];
        int x = low, y = mid + 1, z = 0;
        while(x<=mid && y<=high)
            if(arr[x]<=arr[y])
                merged[z++] = arr[x++];
            else
                merged[z++] = arr[y++];


        while(x<=mid)
            merged[z++] = arr[x++];

        while(y<=high)
            merged[z++] = arr[y++];

        for(int i=0, j=low; i<merged.length; i++, j++)
            arr[j] = merged[i];
    }


    /*
    Optimal Approach: Using merge sort
     */
    private static int countReversePairs(int[] arr, int low, int mid, int high){
        int right=mid+1, count=0;
        for(int i=low; i<=mid; i++){
            while(right<=high && arr[i]>2*arr[right])
                right++;
            count+=right - (mid+1);

        }
        return count;
    }

    public static void main(String[] args) {
        int[] arr = {10, 1, 6, 3, 8, 15, 4, 2, 20, 9,
                30, 12, 18, 5, 50, 14, 7, 19, 60, 13,
                100, 40, 21, 70, 9, 35, 80, 26, 2, 55,
                23, 17, 90, 27, 3, 31, 11, 29, 45, 25,
                120, 5, 33, 8, 16, 2, 77, 6, 28, 36};

        System.out.println("Brute Force Approach Result: "+ bruteForce(arr));
        System.out.println("Optimal Approach Result: "+ mergeSort(arr, 0, arr.length-1));
    }
}
