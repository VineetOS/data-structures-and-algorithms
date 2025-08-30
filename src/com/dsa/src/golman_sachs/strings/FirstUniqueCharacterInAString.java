package com.dsa.src.golman_sachs.strings;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class FirstUniqueCharacterInAString {

    static int optimised(String s){
        if(s==null || s.length()<=1) return 0;
        int[] map = new int[26];
        for(char c: s.toCharArray()) map[c - 'a']++;
        for(int i=0; i<s.length(); i++) if(map[s.charAt(i)-'a']==1) return i;
        return -1;
    }

    static int firstUniqChar(String s){
        if(s==null || s.length()<=1) return 0;
        Map<Character, Integer> map = new HashMap<>();
        for(char c: s.toCharArray()) map.put(c, map.getOrDefault(c,0)+1);
        for(int i=0; i<s.length(); i++) if(map.containsKey(s.charAt(i)) && map.get(s.charAt(i))==1) return i;
        return -1;
    }
}
