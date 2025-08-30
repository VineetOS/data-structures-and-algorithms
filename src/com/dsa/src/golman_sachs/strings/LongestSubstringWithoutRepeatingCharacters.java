package com.dsa.src.golman_sachs.strings;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class LongestSubstringWithoutRepeatingCharacters {

    static int optimal(String s){
        if(s==null || s.isEmpty()) return 0;
        int maxLen = 0, left=0;
        Map<Character,Integer> map = new HashMap<>();

        for(int right=0; right<s.length(); right++){
            char c = s.charAt(right);
            if(map.containsKey(c)  && map.get(c)>=left){
                left = map.get(c)+1;
            }
            map.put(c, right);
            maxLen = Math.max(maxLen, right - left + 1);
        }
        return maxLen;
    }

    public static void main(String[] args) {
        String s = "abba";
        System.out.println(optimal(s));
    }
}
