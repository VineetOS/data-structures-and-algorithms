package com.dsa.src.arrays.dsa_sheet.part3;

public class PowerOfN {

    private static double pow(double x,int n){
        //using binary exponentiation
        double ans = 1.0;
        long nn=n;
        if(nn<0) nn = -1*nn;
        while (nn>0){
            if(nn%2 == 1){
                // assume 2^7
                ans = ans*x;
                nn -= 1;
            }else{
                // assume 2^8 can be written as 4 ^ 2
                x = x*x;
                nn = nn/2;
            }
        }
        if(n<0) ans = 1.00 / ans;
        return ans;
    }

    public static void main(String[] args) {
        double x = 3.26;
        int n =3;
        System.out.println("Value of " + x + " to the power of "+ n+ " is: " + pow(x,n));
    }
}
