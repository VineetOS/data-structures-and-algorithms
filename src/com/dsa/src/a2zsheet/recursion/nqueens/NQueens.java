package com.dsa.src.a2zsheet.recursion.nqueens;

import java.util.ArrayList;
import java.util.List;

public class NQueens {

    static List<List<String>> placeNQueens(int n){
        int[][] board = new int[n][n];
        List<List<String>> res = new ArrayList<>();
        placeHelper(board, 0, res);
        return res;
    }

    static void placeHelper(int[][] board, int col, List<List<String>> finalRes){
        if(col == board.length){
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
            return;
        }
        for(int row = 0; row<board.length; row++){
            if(canPlaceQueen(board, row, col)){
                board[row][col] = 1; //place the queen
                placeHelper(board,col+1,finalRes); //try to place the queen on remaining cols
                board[row][col] = 0; //backtrack
            }
        }
    }

    static boolean canPlaceQueen(int[][] board, int row, int col){

        for(int j=0; j<col; j++){
            for(int i=0; i<board.length; i++){
                //check horizontal direction and vertical direction
                if(board[i][j] == 1 && (i==row || i-col+j == row || i+col-j == row)) return false;
            }
        }
        return true;
    }


    public static void main(String[] args) {
        int n=4;
        List<List<String>> result = placeNQueens(n);
        System.out.println(result);
    }
}
