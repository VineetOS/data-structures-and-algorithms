package com.dsa.src.a2zsheet.strings;

public class CheckIfStringIsRotationOfAnother {

    private static boolean checkBruteForce(String s1, String s2){
        if(s1.length()!= s2.length()) return false;
        //find starting point of second string same as first string
        int n= s1.length() , startPt=0;
        while(startPt<n){
            if(s1.charAt(0) == s2.charAt(startPt)){
                int iS2 = startPt, iS1=0;
                while(iS1<n){
                    if((iS2<n && s1.charAt(iS1) != s2.charAt(iS2)) ||
                            (iS2>=n && s1.charAt(iS1) != s2.charAt(iS2-n))) break;
                    iS1++;
                    iS2++;
                }
                if(iS1==n) return true;
            }
            startPt++;
        }
        return false;
    }

    private static boolean checkOptimal(String s1, String s2){
        return (s1.length() == s2.length()) && (s1+s1).contains(s2);
    }

    public static void main(String[] args) {
        String s1 = "abcdefghab";
        String s2 = "efghababcd";
        System.out.println("Check Brute Force: " + checkBruteForce(s1, s2));
        System.out.println("Check Optimal: " + checkOptimal(s1, s2));

    }
}
