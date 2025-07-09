package com.dsa.src.a2zsheet.arrays.lec2;

public class RotateMatrixBy90Degrees {

    private static void rotateOptimal(int[][] arr){
        int n=arr.length;

        //transpose matrix
        for(int i=0; i<n; i++)
            for(int j=0; j<n; j++)
                swap(arr,i,j,j,i);

        //reverse every row
        for(int i=0; i<n; i++)
            for(int j=0; j<n/2; j++)
                swap(arr,i,j, i, n-i-1);
    }

    private static int[][] rotateBruteForce(int[][] arr){
        int n = arr.length;
        int[][] rotated = new int[n][n];
        for (int i=0; i<n; i++){
            for(int j=0; j<n; j++){
                rotated[j][n-i-1] = arr[i][j];
            }
        }
        return rotated;
    }

    public static void main(String[] args) {
        int[][] arr =  {{1, 2, 3}, {4, 5, 6}, {7, 8, 9}};
        System.out.println("Original Image:");
        printArray(arr);
        int[][] rotated = rotateBruteForce(arr);
        System.out.println("Rotated Image: Brute Force");
        printArray(rotated);
        rotateOptimal(arr);
        System.out.println("Rotated Image: Optimal Approach");
        printArray(rotated);
    }

    private static void printArray(int[][] rotated){
        for (int[] ints : rotated) {
            for (int j = 0; j < rotated.length; j++) {
                System.out.print(ints[j] + " ");
            }
            System.out.println();
        }
    }

    private static void swap(int[][] matrix, int i1, int j1, int i2, int j2){
        int temp = matrix[i1][j1];
        matrix[i1][j1] = matrix[i2][j2];
        matrix[i2][j2] = temp;
    }
}
