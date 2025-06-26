package com.dsa.src.arrays.dsa_sheet.part2;

public class MergeSortAlgorithm {

    public static void main(String[] args) {
        /*
        Implement Merge Sort Algorithm for an Integer Array
         */
        int[] arr = {6,3,4,8,10,2};
        divide(arr,0, arr.length-1);
        for(int i: arr)
            System.out.print(i + " ");
    }


    public static void divide(int[] arr, int low, int high ){

        if(low>=high)
            return;

        //NOTE: sometimes, sum of high and low can reach out of integer bounds,
        //To avoid this we use the following expression for calculating mid
        int mid = low + (high-low)/2;

        divide(arr, low, mid);
        divide(arr, mid+1, high);
        conquer(arr,low,mid,high);
    }

    public static void conquer(int[] arr, int low, int mid, int high){
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

}
