package com.dsa.leetcode.day2;

import java.util.Arrays;

public class LongestCommonPrefix {

    private static String sortingSolution(String[] strs){
        /*
        Time complexity: O(NlogN + M) where N-> length of strs and M-> max length of a string
        Space complexity: O(N) for sorting
         */
        StringBuilder res = new StringBuilder();

        //Sort the array
        Arrays.sort(strs);

        char[] first = strs[0].toCharArray();
        char[] last = strs[strs.length-1].toCharArray();

        for(int i=0; i<first.length; i++){
            if(first[i] != last[i])
                break;
            res.append(first[i]);
        }
        return res.toString();
    }

    private static String optimalApproach(String[] strs){
        /*
        Time complexity: O(NxM) where N-> length of strs and M-> max length of a string
        Space complexity: O(1)
         */
        String pref = strs[0];
        for(int i=1; i<strs.length; i++){
            while(!strs[i].startsWith(pref)){
                pref = pref.substring(0, pref.length()-1);
                if(pref.isEmpty())
                    return "";
            }
        }
        return pref;
    }

    public static void main(String[] args) {
        String[] strs = {"flower","flow","flight"};
        System.out.println("Sorting Approach: "+ sortingSolution(strs));
        System.out.println("Optimal Approach: "+ optimalApproach(strs));

    }
}
