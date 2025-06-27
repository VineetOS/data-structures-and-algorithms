package com.dsa.src.dsa_sheet.strings;

public class ReverseWordsInAString {

    private static String reverse(String str){
        return new StringBuilder(str).reverse().toString();
    }
    private static String reverseWords(String str){
        int n = str.length();
        StringBuilder ans = new StringBuilder();
        str = reverse(str);
       for(int i=0; i<n; i++){
           StringBuilder word = new StringBuilder();
           while(str.charAt(i)!= ' ' && i<n){
               word.append(str.charAt(i));
               i++;
           }
           word = new StringBuilder( reverse(word.toString()) );
           if(!word.isEmpty()){
               ans.append(" ").append(word);
           }
       }

       return ans.substring(1);
    }

    public static void main(String[] args) {
        String str = "  hello     world   guys   ";
        System.out.println(reverseWords(str));
    }
}
