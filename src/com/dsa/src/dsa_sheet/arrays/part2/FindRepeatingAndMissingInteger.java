package com.dsa.src.dsa_sheet.arrays.part2;

import java.util.Arrays;

public class FindRepeatingAndMissingInteger {

    private static int[] findRepeatedAndMissingIntegerMaths(int[] arr){
        int n=arr.length;
        //sum of n integers and sum of squares of n integers
        long Sn = ((long) n * (n+1))/2, S=0;
        long S2n = (n*(n+1)*(2L *n+1))/6, S2=0;

        // now calculate actual sum and actual sum of squares
        for(int i: arr){
            S+= i;
            S2+= (long) i *i;
        }

        // X- Y will be S - Sn
        long val1 = S - Sn;

        // X^2 - Y^2 will be S2 - S2n
        long val2 = S2 - S2n;
        val2 = val2/val1;

        //Find X and Y: X = ((X+Y)+(X-Y))/2 and Y = X-(X-Y),
        // Here, X-Y = val1 and X+Y = val2:
        long x = (val1 + val2) / 2;
        long y = x - val1;

        return new int[]{(int)x, (int)y};
    }

    public static int[] findMissingRepeatingNumbersXORApproach(int[] a) {
        int n = a.length; // size of the array
        int xr = 0;

        //Step 1: Find XOR of all elements:
        for (int i = 0; i < n; i++) {
            xr = xr ^ a[i];
            xr = xr ^ (i + 1);
        }

        //Step 2: Find the differentiating bit number:
        int number = (xr & -xr);

        //Step 3: Group the numbers:
        int zero = 0;
        int one = 0;
        for (int k : a) {
            //part of 1 group:
            if ((k & number) != 0) {
                one = one ^ k;
            }
            //part of 0 group:
            else {
                zero = zero ^ k;
            }
        }

        for (int i = 1; i <= n; i++) {
            //part of 1 group:
            if ((i & number) != 0) {
                one = one ^ i;
            }
            //part of 0 group:
            else {
                zero = zero ^ i;
            }
        }

        // Last step: Identify the numbers:
        int cnt = 0;
        for (int j : a) {
            if (j == zero) cnt++;
        }

        if (cnt == 2) return new int[] {zero, one};
        return new int[] {one, zero};
    }


    public static void main(String[] args) {
        int[] arr = {3,1,2,5,3};
        System.out.println("Repeated and missing integer using maths: " + Arrays.toString(findRepeatedAndMissingIntegerMaths(arr)));
        System.out.println("Repeated and missing integer using XOR Approach: " + Arrays.toString(findMissingRepeatingNumbersXORApproach(arr)));

    }
}
