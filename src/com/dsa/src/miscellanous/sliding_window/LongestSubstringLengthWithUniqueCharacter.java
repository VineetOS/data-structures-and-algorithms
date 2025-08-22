package com.dsa.src.miscellanous.sliding_window;

import java.util.HashSet;
import java.util.Set;

public class LongestSubstringLengthWithUniqueCharacter {

    static int longestUniqueSubString(String s){
        int maxLen = 0, left=0, n=s.length();
        Set<Character> store = new HashSet<>();
        for(int i=0; i<n;i++){
            if(!store.contains(s.charAt(i))){
                store.add(s.charAt(i));
                maxLen = Math.max(store.size(),maxLen);
            }else{
                while(left<n && store.contains(s.charAt(i))){
                    store.remove(s.charAt(left));
                    left++;
                }
                store.add(s.charAt(i));
            }
        }
        return maxLen;
    }


    public static void main(String[] args) {

    }
}
