package com.dsa.src.a2zsheet.strings;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class LongestCommonPrefix {

    private static String longestCommonPrefixOptimal(List<String> words){
        int n = words.size();
        words.sort(Comparator.naturalOrder());
        String prefix = words.get(0), lastWord = words.get(n-1);
        while(!prefix.startsWith(lastWord))
            lastWord = lastWord.substring(0, lastWord.length()-1);
        return lastWord;

    }

    private static String longestCommonPrefix(List<String> words){
        int n = words.size();
        words.sort(Comparator.comparingInt(String::length));

        String prefix = words.get(0);

        for(int i=1; i<n; i++){
            String currWord = words.get(i);
            while(!currWord.startsWith(prefix)){
                prefix = prefix.substring(0, prefix.length()-1);
                currWord = currWord.substring(0, prefix.length());
            }
        }
        return prefix;
    }

    public static void main(String[] args) {
        List<String> words = new ArrayList<>( List.of("flight", "flow", "flower", "fling", "flint"));
        System.out.println("Horizontal search " +longestCommonPrefix(words));
        System.out.println("Sorting Approach: "+ longestCommonPrefixOptimal(words));
    }
}
