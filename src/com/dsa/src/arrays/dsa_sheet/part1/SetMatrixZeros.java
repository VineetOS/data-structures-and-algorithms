package com.dsa.src.arrays.dsa_sheet.part1;

import java.util.*;

public class SetMatrixZeros {

    private static int[][] setMatrixZero(int[][] matrix){
        int[] rowsToSetZero = new int[matrix.length];
        int[] colsToSetZero = new int[matrix[0].length];

        for(int row=0; row< matrix.length; row++){
            for(int col=0; col<matrix[0].length; col++){
                if(matrix[row][col] == 0){
                    rowsToSetZero[row] = 1;
                    colsToSetZero[col]= 1;
                }
            }
        }

        for(int row=0; row< matrix.length; row++){
            for(int col=0; col<matrix[0].length; col++){
                if(rowsToSetZero[row] == 1 || colsToSetZero[col] == 1){
                    matrix[row][col] = 0;
                }
            }
        }
        return matrix;
    }

    private static int[][] setMatrixZeroOptimalApproach(int[][] matrix){
        int col0 = -1;
        for(int row=0; row< matrix.length; row++){
            for(int col=0; col<matrix[0].length; col++){
                if(matrix[row][col] == 0 && col!=0){
                    matrix[row][0] = 0;
                    matrix[0][col]= 0;
                }else if(matrix[row][col] == 0 && col==0){
                    col0 = 0;
                }
            }
        }

        for(int row=1; row< matrix.length; row++){
            for(int col=1; col<matrix[0].length; col++){
                if(matrix[0][col] == 0 || matrix[row][0] == 0){
                    matrix[row][col] = 0;
                }
            }
        }

        if(matrix[0][0] == 0){
            for(int i=0; i<matrix.length; i++){
                matrix[i][0] =0;
            }
        }
        if(col0 == 0){
            Arrays.fill(matrix[0], 0);
        }

        for(int row=0; row< matrix.length; row++){
            for(int col=0; col<matrix[0].length; col++){
                if(matrix[row][col] == -1){
                    matrix[row][col] = 0;
                }
            }
        }
        return matrix;
    }

    public static void main(String[] args) {
        int[][] matrix = {{0,1,2,0},{3,4,5,2},{1,3,1,5}};
        printMatrix(setMatrixZeroOptimalApproach(matrix));
    }

    private static void printMatrix(int[][] matrix) {
        for (int[] ints : matrix) {
            for (int j = 0; j < matrix[0].length; j++)
                System.out.print(ints[j] + " ");
            System.out.println();
        }
    }
}
