package com.dsa.arrays.grids;

public class GridUniquePaths {

    /*
        Recursive solution:
        if the program reaches end point -> return 1
        if program goes out of bounds -> return 0
        else sum of count of both possibilities' viz. going right, down
     */
    public static int countUniquePaths(int i, int j, int n, int m){
        if(i==n-1 && j == m-1) return 1;
        if(i>=n || j>=m) return 0;
        else return countUniquePaths(i+1,j,n,m) + countUniquePaths(i,j+1,n,m);
    }

    public static int gridUniquePaths(int n, int m){
        return countUniquePaths(0,0,n,m);
    }

    /*
        Dynamic Programming Solution:
        We store all the paths in a 2D array so that we do not traverse the same path twice
     */

    public static int countPathsDP(int n, int m, int i, int j, int[][] dp){
        if(i == n-1 && j == m-1) return 1;
        if(i >= n || j >=m) return 0;
        if(dp[i][j] != -1) return dp[i][j];
        else return dp[i][j] = countPathsDP(n,m,i+1,j, dp) + countPathsDP(n,m,i, j+1,dp);
    }

    public static int gridUniquePathsDP(int n, int m){
        int[][] dp = new int[n][m];
        //fill 2D array with all values as -1
        for(int i=0; i<n; i++)
            for(int j=0; j<m; j++)
                dp[i][j] = -1;


        int num = countPathsDP(n, m, 0, 0, dp);
        if(m == 1 && n == 1) return num;
        return dp[0][0];
    }

    /*
        Combinatorics Approach:
            Total Steps required to reach the end is m+n-2
            We need m-1 right steps and n-1 down steps
            Using formula of PnC: m+n-2 C n-1 * m+n-2 C m-1
            We just need to calculate this value now...
     */

    public static int gridUniquePathsC(int n, int m){
        double res = 1;
        int N = m+n-2;
        int r = m-1;

        // IMP: calculation of factorials
        for (int i = 1; i <= r; i++)
            res = res * (N - r + i) / i;

        return (int) res;
    }

    public static void main(String[] args) {
        /*
            Problem Statement:
                Given a matrix m X n,
                count paths from left-top to the right bottom of a matrix with the constraints that from each cell
                you can either only move to the rightward direction or the downward direction.
         */

        int n=3, m=15;
        System.out.println("Unique paths for n: " + n + " and m: " +
                m + " are as follows:");
        System.out.println("Recursive Approach: " + gridUniquePaths(n,m));
        System.out.println("Dynamic Programming: " + gridUniquePathsDP(n,m));
        System.out.println("Combinatorics Approach: " + gridUniquePathsC(n,m));

    }
}
