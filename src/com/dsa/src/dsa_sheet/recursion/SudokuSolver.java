package com.dsa.src.dsa_sheet.recursion;

public class SudokuSolver {

    static boolean solveSudoku(char[][] sudoku){
        for(int i=0; i<sudoku.length; i++){
            for(int j=0; j<sudoku.length; j++){
                if(sudoku[i][j] == '.'){
                    for(char c = '1'; c<='9'; c++){
                        if(isValid(sudoku,i,j,c)){
                            sudoku[i][j] = c;
                            if(solveSudoku(sudoku))
                                return true;
                            sudoku[i][j] = '.';
                        }
                    }
                    return false;
                }
            }
        }
        return true;
    }

    static boolean isValid(char[][] board, int row, int col, char c){
        for(int i=0; i<9; i++){
            //row check
            if(board[i][col] == c) return false;
            //col check
            if(board[row][i] == c) return false;
            //3x3 block check
            if(board[3*(row/3) + i/3][3*(col/3) + i%3] == c) return false;
        }
        return true;
    }

    public static void main(String[] args) {
        char[][] sudoku = new char[9][9];

    }
}
