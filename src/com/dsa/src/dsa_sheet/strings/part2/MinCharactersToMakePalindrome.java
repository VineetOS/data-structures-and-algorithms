package com.dsa.src.dsa_sheet.strings.part2;

public class MinCharactersToMakePalindrome {

    static int minCharactersToMakePalindromeBruteForce(String str) {
        int n = str.length();
        if(n <= 1) return 0; // A single character or empty string is already a palindrome
        for(int i=0; i<n; i++){
            if(checkPalindrome(str,i,n-1)){
                return i; // If we find a palindrome starting from index i, return the number of characters before it
            }
        }
        return n; // If no palindrome is found, we need to add all characters
    }

    static boolean checkPalindrome(String s, int left, int right){
        while (left < right) {
            if(s.charAt(left)!=s.charAt(right)) return false;
            left++;
            right--;
        }
        return true;
    }

    public static void main(String[] args) {
        String str = "cbcc";
        int result = minCharactersToMakePalindromeBruteForce(str);
        System.out.println("Minimum characters to make palindrome: " + result);
    }
}
