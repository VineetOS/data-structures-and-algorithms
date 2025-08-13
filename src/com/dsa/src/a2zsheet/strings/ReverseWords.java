package com.dsa.src.a2zsheet.strings;

import java.util.ArrayDeque;


public class ReverseWords {

    private static String reverseOptimal(String s){
        StringBuilder currWord = new StringBuilder();
        StringBuilder res = new StringBuilder();

        for(int i=0; i<s.length(); i++){
            char ch = s.charAt(i);
            if(ch != ' ') currWord.append(ch);
            else {
                if (res.isEmpty()) res = new StringBuilder(currWord.toString());
                else res.insert(0, currWord + " ");
                currWord.setLength(0);
            }
        }
        if(!currWord.isEmpty()) res.insert(0, currWord + " ");
        return res.toString();
    }

    private static String reverseBruteForce(String s){
        StringBuilder currWord = new StringBuilder();
        ArrayDeque<String> words = new ArrayDeque<>();

        for(int i=0; i<s.length();i++)
            if(s.charAt(i) == ' '){
                if(!currWord.isEmpty()) words.push(currWord.toString());
                currWord.setLength(0);
            }
            else currWord.append(s.charAt(i));


        //add last word to the stack
        if(!currWord.isEmpty()) words.push(currWord.toString());
        return String.join(" ", words);
    }

    public static void main(String[] args) {
        String s = "method the by sentence reversed the is This";
        System.out.println("Brute force: "+  reverseBruteForce(s) );
        System.out.println("Optimal: "+ reverseOptimal(s));
    }
}
