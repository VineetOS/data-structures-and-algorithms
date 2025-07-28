package com.dsa.src.a2zsheet.binary_search.lec1;

public class SearchSingleElementInSortedArray {

    private static int findSingleElement(int[] arr){
        if(arr.length == 1) return arr[0]; // If the array has only one element, return it
        if(arr[0] != arr[1]) return arr[0]; // If the first element is unique, return it
        if(arr[arr.length - 1] != arr[arr.length - 2]) return arr[arr.length - 1]; // If the last element is unique, return it

        int low = 1, high = arr.length - 2;
        while(low<=high){
            int mid = low + (high - low) / 2;
            if(arr[mid] != arr[mid - 1] && arr[mid] != arr[mid + 1]) {
                return arr[mid]; // Found the single element
            }
            if((mid%2==1 && arr[mid] == arr[mid-1]) ||
                    (mid%2==0 && arr[mid] == arr[mid+1]))
                low = mid + 1; //element in the right half
            else
                high = mid - 1; //element in the left half
        }
        return -1; // This line should never be reached if the input is valid
    }

    public static void main(String[] args) {
        int[] arr = {1, 1, 2, 3, 3, 4, 4, 5, 5,6,6,7,7};
        int singleElement = findSingleElement(arr);
        System.out.println("The single element in the sorted array is: " + singleElement);
    }
}
