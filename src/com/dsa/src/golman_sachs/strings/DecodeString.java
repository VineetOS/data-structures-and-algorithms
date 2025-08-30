package com.dsa.src.golman_sachs.strings;

import java.util.Stack;

public class DecodeString {

    static String decodeRecursion(String s){
        return recursionHelper(s, new int[]{0});
    }

    static String recursionHelper(String s, int[] index){
        StringBuilder result = new StringBuilder();
        int count = 0;
        while(index[0]<s.length()){
            char c = s.charAt(index[0]);
            if(Character.isDigit(c)){
                count = count*10 + (c - '0');
                index[0]++;
            }else if(c == '['){
                index[0]++;
                String decodedString = recursionHelper(s, index);
                decodedString = decodedString.repeat(count);
                result.append(decodedString);
                count=0;
            }else if(c == ']'){
                index[0]++;
                return result.toString();
            }else{
                result.append(c);
                index[0]++;
            }
        }
        return result.toString();
    }

    static String decodeString(String s){
        Stack<Integer> counts = new Stack<>();
        Stack<StringBuilder> results = new Stack<>();
        StringBuilder current = new StringBuilder();
        int count=0;

        for(char c: s.toCharArray()){
            if(Character.isDigit(c)) count = count*10 + (c - '0');
            else if(c == '['){
                counts.push(count);
                results.push(current);
                count=0;
                current = new StringBuilder();
            }else if(c == ']'){
                int valCount = counts.pop();
                StringBuilder decoded = results.pop();
                decoded.append(current.toString().repeat(valCount));
                current=decoded;
            }else current.append(c);
        }
        return current.toString();
    }


    public static void main(String[] args) {
        String s = "3[a2[b]]20[x]";
        System.out.println(decodeString(s));
        System.out.println(decodeRecursion(s));
    }
}
