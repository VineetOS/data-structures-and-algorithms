package com.dsa.src.golman_sachs.recursion;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class AllPossibleWordsFromPhoneNumber {

    static List<String> allPossibleWords(String number){
        Map<Character,List<Character>> numberCharMap = new HashMap<>();
        generateMap(numberCharMap);
        List<String> ans = new ArrayList<>();
        helper(number, numberCharMap, 0, ans, new StringBuilder());
        return ans;
    }

    static void helper(String number, Map<Character, List<Character>> map, int idx,List<String> ans, StringBuilder curr ){
        if(idx == number.length()){
            ans.add(curr.toString());
            return;
        }
        List<Character> chars = map.get(number.charAt(idx));
        for(char c: chars){
            curr.append(c);
            helper(number, map, idx+1, ans, curr);
            curr.deleteCharAt(curr.length()-1);
        }
    }

    public static void main(String[] args) {
        String num = "23";
        System.out.println(allPossibleWords(num));
    }

    static void generateMap(Map<Character, List<Character>> map){
        map.put('2', List.of('a','b','c'));
        map.put('3', List.of('d','e', 'f'));
        map.put('4', List.of('g','h','i'));
        map.put('5', List.of('j','k','l'));
        map.put('6', List.of('m','n','o'));
        map.put('7', List.of('p','q','r','s'));
        map.put('8', List.of('t','u','v'));
        map.put('9', List.of('w','x','y','z'));
    }
}
