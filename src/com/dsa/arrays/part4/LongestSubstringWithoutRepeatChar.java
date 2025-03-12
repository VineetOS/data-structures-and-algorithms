package com.dsa.arrays.part4;

import java.util.HashSet;
import java.util.Set;

public class LongestSubstringWithoutRepeatChar {

    private static int betterApproach(String s){
        char[] charArray = s.toCharArray();
        Set<Character> tempSet = new HashSet<>();
        int count=0, res=0;
        for(char c: charArray){

            if(!tempSet.contains(c)){
                count++;
            }else{
                count=1;
                tempSet.clear();
            }
            tempSet.add(c);
            res = Math.max(res,count);
        }
        return res;
    }

    public static void main(String[] args) {
        String s = "bbbbbbabeeeefga";
        System.out.println("Better Approach: " + betterApproach(s));
    }
}
