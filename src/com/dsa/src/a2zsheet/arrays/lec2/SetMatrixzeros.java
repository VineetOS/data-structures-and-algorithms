package com.dsa.src.a2zsheet.arrays.lec2;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class SetMatrixzeros {

    private static void optimalApproach(List<List<Integer>> matrix, int n, int m){
        int col0 =-1;
        for(int i=0; i<n; i++){
            for(int j=0; j<m; j++){
                if(matrix.get(i).get(j)==0){
                    matrix.get(i).set(0,0);
                    if(j!=0) matrix.get(0).set(j,0);
                    else col0 = 0;
                }
            }
        }
        for(int i=1; i<n; i++){
            for(int j=1; j<m; j++){
                if(matrix.get(i).get(j) != 0)
                    if(matrix.get(i).get(0) == 0 || matrix.get(0).get(j)==0 ) matrix.get(i).set(j,0);
            }
        }
        //step 3: Finally mark the 1st col & then 1st row:
        if (matrix.get(0).get(0) == 0) {
            for (int j = 0; j < m; j++) {
                matrix.get(0).set(j, 0);
            }
        }
        if (col0 == 0) {
            for (int i = 0; i < n; i++) {
                matrix.get(i).set(0, 0);
            }
        }
    }

    private static void betterApproach(List<List<Integer>> matrix, int n, int m){
        int[] rows = new int[n];
        int[] cols = new int[m];
        for(int i=0; i<n; i++){
            for(int j=0; j<m; j++){
                if(matrix.get(i).get(j) == 0){
                    rows[i] = -1;
                    cols[j] = -1;
                }
            }
        }
        for(int i=0; i<n; i++){
            for(int j=0; j<m; j++){
                if(rows[i] == -1 || cols[j] == -1)
                    matrix.get(i).set(j,0);
            }
        }
    }

    public static void main(String[] args) {
        List<List<Integer>> matrix = initializeMatrix();
        int n = matrix.size();
        int m = matrix.get(0).size();
        bruteForce(matrix, n, m);
        System.out.println("The Final matrix for brute force : ");
        printMatrix(matrix);
        matrix = initializeMatrix();
        betterApproach(matrix,n,m);
        System.out.println("The Final matrix for better approach : ");
        printMatrix(matrix);

        matrix = initializeMatrix();
        betterApproach(matrix,n,m);
        System.out.println("The Final matrix for Better force : ");
        printMatrix(matrix);

        matrix = initializeMatrix();
        optimalApproach(matrix,n,m);
        System.out.println("The Final matrix for Optimal force : ");
        printMatrix(matrix);
    }

    private static void bruteForce(List<List<Integer>> matrix, int n, int m) {
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (matrix.get(i).get(j) == 0) {
                    setColInMatrix(matrix, n, m, j);
                    setRowInMatrix(matrix, n, m, i);
                }
            }
        }
        for (int i = 0; i < n; i++)
            for (int j = 0; j < m; j++)
                if (matrix.get(i).get(j) == -1) matrix.get(i).set(j, 0);
    }

    private static void setRowInMatrix(List<List<Integer>> matrix, int n, int m, int row) {
        for (int j = 0; j < m; j++)
            if (matrix.get(row).get(j) != 0) matrix.get(row).set(j, -1);
    }


    private static void setColInMatrix(List<List<Integer>> matrix, int n, int m, int col) {
        for (int j = 0; j < n; j++)
            if (matrix.get(j).get(col) != 0) matrix.get(j).set(col, -1);
    }


    private static void printMatrix(List<List<Integer>> matrix) {
        for (List<Integer> row : matrix) {
            for (Integer ele : row) {
                System.out.print(ele + " ");
            }
            System.out.println();
        }
    }

    private static List<List<Integer>> initializeMatrix() {
        List<List<Integer>> matrix = new ArrayList<>();
        matrix.add(new ArrayList<>(Arrays.asList(1, 1, 1, 1)));
        matrix.add(new ArrayList<>(Arrays.asList(1, 0, 1, 0)));
        matrix.add(new ArrayList<>(Arrays.asList(1, 1, 1, 1)));
        return matrix;
    }
}
