package com.dsa.src.golman_sachs.recursion;

public class MaxPathSumInMatrix {

    static int dpOptimised(int[][] matrix){
        int n = matrix.length, m = matrix[0].length;
        int[] prev = new int[m];
        prev[0] = matrix[0][0];
        for(int i=1; i<m; i++) prev[i] = prev[i-1] + matrix[0][i];

        for(int i=1; i<n; i++){
            prev[0]+= matrix[i][0];
            for(int j=1; j<m; j++){
                prev[j] = matrix[i][j] + Math.max(prev[j-1], prev[j]);
            }
        }
        return prev[m-1];
    }

    static int dpApproach(int[][] matrix){
        int n = matrix.length, m = matrix[0].length;
        int[][] dp = new int[n][m];
        for(int i=0; i<n; i++){
            for(int j=0; j<m; j++){
                if(i==0 && j==0) dp[i][j] = matrix[i][j];
                else if(i==0) dp[i][j] = matrix[i][j] + dp[i][j-1];
                else if(j==0) dp[i][j] = matrix[i][j] + dp[i-1][j];
                else dp[i][j] = matrix[i][j] + Math.max(dp[i][j-1], dp[i-1][j]);
            }
        }
        return dp[n-1][m-1];
    }

    static int recApproach(int[][] matrix){
        return recursionHelper(matrix,matrix.length-1,matrix[0].length-1);
    }

    static int recursionHelper(int[][] matrix, int i, int j){
        if(i<0 || j<0) return Integer.MIN_VALUE;
        if(i==0 && j==0) return matrix[0][0];
        return matrix[i][j] + Math.max(recursionHelper(matrix, i-1,j),
                                        recursionHelper(matrix,i,j-1));
    }


}
