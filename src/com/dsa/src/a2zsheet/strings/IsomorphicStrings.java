package com.dsa.src.a2zsheet.strings;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

public class IsomorphicStrings {

    private static boolean checkOptimal(String s1, String s2){
        if(s1.length()!=s2.length()) return false;
        int[] mapS1S2 = new int[256];
        int[] mapS2S1 = new int[256];

        for(int i=0; i< s1.length(); i++){
            char c1 = s1.charAt(i), c2 = s2.charAt(i);
            if(mapS1S2[c1] == 0 && mapS2S1[c2] == 0){
                mapS1S2[c1] = c2;
                mapS2S1[c2] = c1;
            }else if(mapS1S2[c1]!=c2 || mapS2S1[c2]!=c1) return false;
        }
        return true;
    }

    private static boolean checkBetterApproach(String s1, String s2){
        if(s1.length()!=s2.length()) return false;
        Map<Character, Integer> mapC1 = new HashMap<>();
        Map<Character, Integer> mapC2 = new HashMap<>();

        for(int i=0; i<s1.length(); i++){
            Character c1 = s1.charAt(i), c2 = s2.charAt(i);
            if(mapC1.containsKey(c1) && mapC2.containsKey(c2)){
                if(!mapC1.get(c1).equals(mapC2.get(c2))) return false;
            }else if( (mapC2.containsKey(c2) && !mapC1.containsKey(c1)) ||
                    (mapC1.containsKey(c1) && !mapC2.containsKey(c2))) return false;
            mapC1.putIfAbsent(c1, i);
            mapC2.putIfAbsent(c2,i);
        }
        return true;
    }

    private static boolean checkBruteForce(String s1, String s2){
        if(s1.length()!=s2.length()) return false;
        int n = s1.length();
        Map<Character,Character> charMapping = new HashMap<>();

        for(int i=0; i<n; i++){
            Character c1 = s1.charAt(i), c2 = s2.charAt(i);
            if(charMapping.containsKey(c1)) {
                if (charMapping.get(c1) != c2)
                    return false;
            }
            else if(charMapping.containsValue(c2)) return false;
            charMapping.put(c1,c2);
        }
        return true;
    }

    public static void main(String[] args) {
        String s1 = "add", s2 = "egg";
        System.out.println(checkBruteForce(s1,s2));
        System.out.println(checkBetterApproach(s1,s2));
    }
}
