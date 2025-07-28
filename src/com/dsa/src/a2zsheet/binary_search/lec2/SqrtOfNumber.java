package com.dsa.src.a2zsheet.binary_search.lec2;

public class SqrtOfNumber {

    private static int findSquareRoot(int x){
        int low = 1, high = x, ans=0;
        while (low<=high){
            int mid = low + (high - low)/2;
            if(mid*mid<=x){
                ans = mid; // mid is a potential answer
                low = mid + 1; // try for a larger value
            } else {
                high = mid - 1; // try for a smaller value
            }
        }
        return ans; // Return the largest integer whose square is less than or equal to x
    }

    public static void main(String[] args) {
        int number = 628; // Example number
        int sqrt = findSquareRoot(number);
        System.out.println("The square root of " + number + " is: " + sqrt);
    }
}
