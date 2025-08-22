package com.dsa.src.miscellanous.sliding_window;

import java.util.HashMap;
import java.util.Map;

public class MinimumWindowSubstring {

    static String minWindow(String s, String t){
        int n=s.length();
        Map<Character, Integer> tMap = new HashMap<>();
        Map<Character,Integer> sMap = new HashMap<>();
        for(char c: t.toCharArray()) tMap.put(c, tMap.getOrDefault(c,0)+1);

        int left=0, right=0, required=tMap.size();
        int formed = 0;
        int[] ans = {-1,0,0};

        while(right<n){
            char c = s.charAt(right);
            sMap.put(c, sMap.getOrDefault(c,0)+1);
            if(tMap.containsKey(c) && sMap.get(c).intValue()==tMap.get(c)){
                formed++;
            }
            while(left<n && required==formed){
                c = s.charAt(left);
                if(ans[0]==-1 || ans[0]>right-left+1){
                    ans[0] = right-left+1;
                    ans[1] = left;
                    ans[2] = right;
                }
                sMap.put(c, sMap.get(c)-1);
                if(tMap.containsKey(c) && tMap.get(c)> sMap.get(c)) formed--;
                left++;
            }
            right++;
        }
        return ans[0]==-1?"": s.substring(ans[1],ans[2]+1);
    }


    public static void main(String[] args) {

    }
}
