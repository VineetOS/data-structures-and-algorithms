package com.dsa.src.a2zsheet.strings;

import java.util.*;

public class SortStringByFrequency {

    private String bruteForce(String s){
        int n = s.length();
        Map<Character, Integer> freqMap = new HashMap<>();
        Map<Integer, List<Character>> keyMap = new HashMap<>();

        for(int i=0; i<n; i++){
            char c = s.charAt(i);
            freqMap.put(c, freqMap.getOrDefault(c,0)+1);
        }

        for(var element: freqMap.entrySet()){
            int frequency = element.getValue();
            char c = element.getKey();
            List<Character> chars = keyMap.getOrDefault(frequency, new ArrayList<>());
            chars.add(c);
            keyMap.put(frequency, chars);
        }

        StringBuilder res = new StringBuilder();
        for (int i=n; i>0; i--) {
            if(keyMap.containsKey(i))
                for(var character: keyMap.get(i))
                    res.append(String.valueOf(character).repeat(i));
        }
        return res.toString();

    }

    public static void main(String[] args) {

    }
}
