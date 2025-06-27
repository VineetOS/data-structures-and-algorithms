package com.dsa.src.dsa_sheet.arrays.part1;

public class PascalTriangle {

    private static void printPascalTriangle(int n){
        for(int i=0; i<n ; i++){
            int num=1;
            for(int j=0; j<=i; j++) {
                System.out.print(num + " ");
                num = num*(i-j)/(j+1);
            }
            System.out.println();
        }
    }

    private static long findElementOfPascalTriangle(int row, int col){
        long res = 1;
        //formula for element = n-1 C r-1
        int n = row-1, r = col -1;
        for(int i=0; i<r; i++){
            res = res*(n-i);
            res = res/(i+1);
        }
        return res;
    }

    private static void printNthRowOfPascalTriangle(int n){
        int res = 1;
        System.out.print(res + " ");

        for(int i=1; i<n; i++){
            res = (res*(n-i))/i;
            System.out.print(res + " ");
        }
        System.out.println();
    }
    public static void main(String[] args) {
        System.out.println("Printing Pascal's Triangle of size: 4");
        printPascalTriangle(4);

        System.out.println("Print 5th Row of Pascal's Triangle");
        printNthRowOfPascalTriangle(5);

        System.out.println("Find nth Element of Pascal's Triangle for 5th row and 3rd element: "+ findElementOfPascalTriangle(5,3));
    }
}
