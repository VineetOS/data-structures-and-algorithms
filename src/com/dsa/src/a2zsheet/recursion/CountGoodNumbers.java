package com.dsa.src.a2zsheet.recursion;

public class CountGoodNumbers {

    private static long countGoodNumbers(long n){
        long mod = 1_000_000_007;
        long evensRes = 4*modPow(5,(n-1)/2,mod);
        long oddsRes = modPow(4, n/2, mod);
        return (int) ((evensRes*oddsRes)%mod);
    }

    private static long modPow(long base, long exp, long mod) {
        long result = 1;
        base %= mod;
        while (exp > 0) {
            if ((exp & 1) == 1) result = (result * base) % mod;
            base = (base * base) % mod;
            exp >>= 1;
        }
        return result;
    }

    public static void main(String[] args) {
        long n= 1002;
        System.out.println("Count good numbers for " +n + "digits: "+ countGoodNumbers(n) );
    }
}
