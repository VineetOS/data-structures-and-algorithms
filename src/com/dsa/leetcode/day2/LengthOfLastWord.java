package com.dsa.leetcode.day2;

public class LengthOfLastWord {

    private static int lengthOfLastWordBruteForce(String s){
        int ans=0;
        s=s.trim();
        for(int i=0; i<s.length(); i++){
            if(s.charAt(i) == ' ') ans=0;
            else ans++;
        }
        return ans;
    }

    private static int optimalApproach(String s){
        int ans=0;
        for(int i=s.length()-1; i>=0; i--){
            if(s.charAt(i) == ' ' && ans!=0) return ans;
            else if(s.charAt(i) != ' ') ans++;
        }
        return ans;
    }

    public static void main(String[] args) {
        String s = "   fly me   to   the moon  ";
        System.out.println("Length of last word - Brute Force : "+ lengthOfLastWordBruteForce(s));
        System.out.println("Length of last word - Optimal Approach : "+ optimalApproach(s));

    }
}
