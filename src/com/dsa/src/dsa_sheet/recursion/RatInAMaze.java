package com.dsa.src.dsa_sheet.recursion;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class RatInAMaze {

    static List<String> findPath(int[][] a, int n) {
        List<String> ans = new ArrayList<>();
        int row=0, col=0;

        //start to downward direction
        pathHelper(a, n, ans, new StringBuilder(), row+1, col, 'D');
        //start to right direction
        pathHelper(a, n, ans, new StringBuilder(), row, col+1, 'R');
        Collections.sort(ans);
        return ans;
    }

    static void pathHelper(int[][] a, int n, List<String> ans, StringBuilder curr, int row, int col, char direction) {
        if(row == n-1 && col==n-1) {
            //found
            curr.append(direction);
            ans.add(new String(curr));
            return;
        }
        if(row>=0 && col>=0 && row<n && col<n && a[row][col] == 1) {
            curr.append(direction);
            a[row][col] = 2;

            if(direction != 'U') pathHelper(a, n, ans, curr, row+1, col, 'D');

            if(direction != 'D') pathHelper(a, n, ans, curr, row-1, col, 'U');

            if(direction != 'R') pathHelper(a, n, ans, curr, row, col-1, 'L');

            if(direction != 'L')pathHelper(a, n, ans, curr, row, col+1, 'R');
            curr.deleteCharAt(curr.length()-1);
            a[row][col] = 1;
        }
    }

    public static void main(String[] args) {
        int n = 4;
        int[][] a = {{1,0,0,0},{1,1,0,1},{1,1,0,0},{0,1,1,1}};

        List< String > res = findPath(a, n);
        if (!res.isEmpty()) {
            for (String re : res) System.out.print(re + " ");
            System.out.println();
        } else {
            System.out.println(-1);
        }
    }

}
