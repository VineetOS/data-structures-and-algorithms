package com.dsa.src.a2zsheet.strings;

public class LongestPalindromeSubstring {

    private static String centralExpansion(String s){
        int n=s.length();
        if(n==0 || n==1) return s;
        String res = s.substring(0, 1);
        for(int center=0; center<n; center++){
            //check even palindrome
            int left = center, right=center+1;
            while(left>=0 && right<n && s.charAt(left) == s.charAt(right)){
                left--;
                right++;
            }
            if(right-left-1>res.length()) res = s.substring(left+1, right);

            //check odd palindrome
            left=center;
            right = center;
            while(left>=0 && right<n && s.charAt(left) == s.charAt(right)){
                left--;
                right++;
            }
            if(right-left-1>res.length()) res = s.substring(left+1, right);
        }
        return res;
    }

    private static String bruteForce(String s){
        int n = s.length();
        for(int i=0; i<n; i++)
            for(int j=i+1; j<n; j++)
                if(j-i>0 && checkPalindrome(s.substring(i,j+1)))
                    return s.substring(i,j+1);
        return "";

    }

    private static boolean checkPalindrome(String s){
        int left = 0, right = s.length()-1;
        while (left<right){
            if(s.charAt(left) != s.charAt(right)) return false;
            left++;
            right--;
        }
        return true;
    }

    public static void main(String[] args) {
        String s = "a";
        System.out.println("Brute force: "+ bruteForce(s));
        System.out.println("Center Expansion Approach: " + centralExpansion(s));
    }
}
