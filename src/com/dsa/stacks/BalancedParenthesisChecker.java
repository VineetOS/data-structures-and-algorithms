package com.dsa.stacks;

import java.util.Stack;

public class BalancedParenthesisChecker {

    private static boolean isBalanced(String str){
        if(str.isEmpty() || str.length()%2!=0) return false;

        Stack<Character> stack = new Stack<>();
        for(int i=0;i<str.length(); i++){
            char c = str.charAt(i);
            if(stack.isEmpty()) {
                stack.push(c);
                continue;
            }
            char top = stack.peek();
            if((top == '{' && c == '}')
                || (top == '(' && c == ')')
                || (top == '[' && c == ']')) {
                stack.pop();
            }else{
                stack.push(c);
            }
        }
        return stack.isEmpty();
    }

    public static void main(String[] args) {
        String str = "[{(})]";
        System.out.println("Solution for string: "+ str + " : " + isBalanced(str));
    }
}
