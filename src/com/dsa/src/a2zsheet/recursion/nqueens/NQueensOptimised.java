package com.dsa.src.a2zsheet.recursion.nqueens;

import java.util.ArrayList;
import java.util.List;

public class NQueensOptimised {

    static List<List<String>> placeNQueens(int n){
        int[][] board = new int[n][n];
        int[] leftCol = new int[n];
        int[] lowerDiagonal = new int[2*n-1], upperDiagonal = new int[2*n-1];
        List<List<String>> res = new ArrayList<>();
        placeHelper(board, 0, res, leftCol, lowerDiagonal, upperDiagonal);
        return res;
    }

    static void placeHelper(int[][] board, int col, List<List<String>> finalRes, int[] leftRow, int[] lowerDiagonal, int[] upperDiagonal){
        if(col == board.length){
            constructSolution(board,finalRes);
            return;
        }
        for(int row = 0; row<board.length; row++){
            if(leftRow[row] == 0 && lowerDiagonal[row+col]==0 && upperDiagonal[board.length -1 + col - row]==0){
                board[row][col] = 1; //place the queen
                leftRow[row] = 1;
                lowerDiagonal[row + col] = 1;
                upperDiagonal[board.length - 1 + col - row] = 1;
                //try to place the queen on remaining cols
                placeHelper(board,col+1,finalRes, leftRow, lowerDiagonal,upperDiagonal);

                //backtracking steps
                board[row][col] = 0;
                leftRow[row] = 0;
                lowerDiagonal[row+col] = 0;
                upperDiagonal[board.length -1 + col - row] = 0;
            }
        }
    }

    static void constructSolution(int[][] board, List<List<String>> finalRes){
        List<String> currSol = new ArrayList<>();
        for(int[] row: board){
            StringBuilder s = new StringBuilder();
            for(int column: row){
                if(column == 1) s.append('Q');
                else s.append('.');
            }
            currSol.add(s.toString());
        }
        finalRes.add(currSol);
    }

    public static void main(String[] args) {
        int n=4;
        List<List<String>> result = placeNQueens(n);
        System.out.println(result);
    }
}
