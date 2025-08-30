package com.dsa.src.miscellanous.stacks_and_queues;

import java.util.LinkedList;
import java.util.Queue;

public class RottenOranges {

    public static int orangesRotting(int[][] grid) {
        if(grid == null || grid.length == 0 || grid[0].length == 0) return -1;

        int rows = grid.length, cols = grid[0].length;
        Queue<int[]> queue = new LinkedList<>();
        int fresh = 0;

        // Initialize queue with all rotten oranges and count fresh ones
        for(int i = 0; i < rows; i++) {
            for(int j = 0; j < cols; j++) {
                if(grid[i][j] == 2) queue.offer(new int[]{i, j});
                else if(grid[i][j] == 1) fresh++;
            }
        }

        if(fresh == 0) return 0; // No fresh oranges to rot

        int time = 0;
        int[][] dirs = {{-1,0}, {1,0}, {0,-1}, {0,1}}; // 4 directions

        while(!queue.isEmpty()) {
            int size = queue.size();
            boolean rottenThisMinute = false;

            for(int i = 0; i < size; i++) {
                int[] curr = queue.poll();
                int x = curr[0], y = curr[1];

                for(int[] d : dirs) {
                    int nx = x + d[0], ny = y + d[1];

                    if(nx >= 0 && nx < rows && ny >= 0 && ny < cols && grid[nx][ny] == 1) {
                        grid[nx][ny] = 2; // Rot the fresh orange
                        queue.offer(new int[]{nx, ny});
                        fresh--;
                        rottenThisMinute = true;
                    }
                }
            }

            if(rottenThisMinute) time++; // Increment only if at least one orange rotted
        }

        return fresh == 0 ? time : -1; // If any fresh oranges remain, return -1
    }


    public static void main(String[] args) {
        int[][] grid = {
            {2, 1, 0},
            {0, 1, 0},
            {1, 0, 2}
        };
        int result = orangesRotting(grid);
        System.out.println("Time taken to rot all oranges: " + result);
        // Expected output: Time taken to rot all oranges: 2
    }
}
