package com.dsa.src.dsa_sheet.arrays.part2;


public class CountInversionsInAnArray {

    private static int merge(int[] arr, int low, int mid, int high) {
        int[] temp = new int[high - low + 1]; // temporary array
        int left = low;      // starting index of left half of arr
        int right = mid + 1;   // starting index of right half of arr
        int tempIndex = 0;

        //Modification 1: cnt variable to count the pairs:
        int cnt = 0;

        /*
            here we have converted the problem
            into a problem of finding inversion pairs in 2 sorted arrays:

            low - (mid) : first array
            mid+1 - high : second array

            ----****----****----****----****----IMPORTANT LOGIC----****----****----****----****----

            if(arr[i]<=arr[j]) -> we do normal insertion
            but if arr[i]>arr[j] -> we have found an inversion
                and all the remaining elements of first array with respect to arr[j]
                will satisfy this condition, so we add the total in our count
         */


        //storing elements in the temporary array in a sorted manner//
        while (left <= mid && right <= high) {
            if (arr[left] <= arr[right])
                temp[tempIndex++] = arr[left++];
            else {
                temp[tempIndex++] = arr[right++];
                cnt += (mid - left + 1); //Modification 2
            }
        }

        // if elements on the left half are still left //
        while (left <= mid)
            temp[tempIndex++] = arr[left++];

        //  if elements on the right half are still left //
        while (right <= high)
            temp[tempIndex++] =arr[right++];

        // transferring all elements from temporary to arr //
        for (int i = low; i <= high; i++) {
            arr[i] = temp[i - low];
        }
        return cnt; // Modification 3
    }

    public static int mergeSort(int[] arr, int low, int high) {
        int cnt = 0;
        if (low >= high) return cnt;
        int mid = (low + high) / 2 ;
        cnt += mergeSort(arr, low, mid);  // left half
        cnt += mergeSort(arr, mid + 1, high); // right half
        cnt += merge(arr, low, mid, high);  // merging sorted halves
        return cnt;
    }

    public static int numberOfInversions(int[] a, int n) {
        // Count the number of pairs:
        return mergeSort(a, 0, n - 1);
    }


    public static void main(String[] args) {
        int[] a = {5, 3, 2, 1, 4};
        int n = 5;
        int cnt = numberOfInversions(a, n);
        System.out.println("The number of inversions are: " + cnt);
    }
}

