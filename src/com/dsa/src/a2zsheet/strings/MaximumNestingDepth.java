package com.dsa.src.a2zsheet.strings;

public class MaximumNestingDepth {


    private static int maxNestingDepth(String s){
        int count=0, maxDepth=0, n=s.length();
        for(int i=0; i<n; i++){
            if(s.charAt(i) == '(') count++;
            else if(s.charAt(i) == ')'){
                maxDepth = Math.max(count,maxDepth);
                count--;
            }
        }
        return maxDepth;
    }

    public static void main(String[] args) {
        String s = "(1+(2*3)+((8)/4))+1";
        System.out.println("Brute force: "+ maxNestingDepth(s));
    }
}
