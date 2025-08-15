package com.dsa.src.a2zsheet.strings;

public class AtioAlgorithm {

    private static int myAtio(String s){
        int sign = 1, n = s.length(), i=0;

        //empty string check
        if(n==0) return 0;

        //leading spaces
        while(i<n && s.charAt(i) == ' ') i++;
        if(i==n) return 0;

        //signs
        if(s.charAt(i) == '+'){
            i++;
        }else if(s.charAt(i) == '-'){
            sign = -1;
            i++;
        }


        //prepare number
        int ans=0;
        while (i < n && Character.isDigit(s.charAt(i))) {
            int digit = s.charAt(i) - '0';

            // Check if adding digit will overflow
            if (ans > (Integer.MAX_VALUE - digit) / 10) {
                return sign == 1 ? Integer.MAX_VALUE : Integer.MIN_VALUE;
            }

            ans = ans * 10 + digit;
            i++;
        }

        return ans*sign;
    }

    public static void main(String[] args) {
        String s = "     -00004576970783624273947453839";
        String s2 = " ";
        System.out.println(myAtio(s2));
    }
}
