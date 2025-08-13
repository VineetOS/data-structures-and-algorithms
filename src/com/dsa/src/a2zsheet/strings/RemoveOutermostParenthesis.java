package com.dsa.src.a2zsheet.strings;

public class RemoveOutermostParenthesis {

    private static String removeOuterParentheses(String s){
        StringBuilder res = new StringBuilder();
        int count = 0; // To track the balance of parentheses
        for(int i=0; i<s.length(); i++){
            if(s.charAt(i) == '(') count++;
            else if(s.charAt(i) == ')') count--;
            if((s.charAt(i) == '(' && count == 1) ||
            (s.charAt(i) == ')' && count == 0)) continue;
            res.append(s.charAt(i));
        }
        return String.valueOf(res);
    }

    public static void main(String[] args) {
        String s = "(()())(())";
        String result = removeOuterParentheses(s);
        System.out.println("Result: " + result); // Expected output: "()()()"
    }
}
